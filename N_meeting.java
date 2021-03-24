import java.util.Arrays;
import java.util.Comparator;

public class N_meeting {
    public static class Pair {
        int s;
        int f;

        Pair(int s, int f) {
            this.s = s;
            this.f = f;
        }
    }

    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(arr, new Comparator<>() {
            // @Override
            public int compare(Pair a1, Pair a2) {
                if (a1.f > a2.f) {
                    return 1;
                }
                return -1;
            }
        });
        int count = 0;
        int last = 0;
        for (Pair i : arr) {
            if (i.s > last) {
                count++;
                last = i.f;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int start[] = { 1, 0, 3, 8, 6, 8 };
        int end[] = { 2, 6, 4, 5, 7, 9 };
        System.out.println("Maximum Number of meeting:" + N_meeting.maxMeetings(start, end, start.length));
    }
}
