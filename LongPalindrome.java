/**
 * LongPalindrome
 */
public class LongPalindrome {
    static int start = 0;
    static int maxlength = 0;

    static void printPalindrome(String S, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(S.charAt(i));
        }
    }

    static void Palindrome(String S, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < j - i + 1; k++) {
                    if (S.charAt(i + k) != S.charAt(j - k)) {
                        flag = false;
                    }
                }
                if (flag && j - i + 1 > maxlength) {
                    start = i;
                    maxlength = j - i + 1;
                }
            }

        }
        System.out.println("Longest Palindrome ");
        printPalindrome(S, start, start + maxlength);
    }

    public static void main(String[] args) {
        String S = "forgeeksskeefor";
        int n = S.length();
        Palindrome(S, n);
    }
}