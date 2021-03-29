import java.util.Arrays;

public class DuplicateString {
    static void PrintAll(String S) {
        int count[] = new int[256];
        Arrays.fill(count, 0);
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] > 1) {
                System.out.println((char) i + ":" + count[i]);
            }
        }
    }

    public static void main(String[] args) {
        String S = "happyholihh";
        PrintAll(S);
    }

}