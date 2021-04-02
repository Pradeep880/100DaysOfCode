import java.util.Arrays;

public class RepeatMissing {
    public static int[] findTwoElement(int arr[], int n) {
        int temp[] = new int[n + 1];
        int rep = -1;
        int miss = -1;
        Arrays.fill(temp, 0);
        for (int i = 0; i < n; i++) {
            if (temp[arr[i]] == 0) {
                temp[arr[i]] = 1;
            } else if (temp[arr[i]] == 1) {
                rep = arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 0)
                miss = i;
        }
        int ar[] = { rep, miss };
        return ar;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 4, 5 };
        int n = arr.length;
        int res[] = findTwoElement(arr, n);
        System.out.println("Repeating element is:" + res[0] + " and Missing element is:" + res[1]);
    }
}
