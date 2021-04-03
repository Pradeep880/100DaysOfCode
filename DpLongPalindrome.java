public class DpLongPalindrome {
    static void printPalindrome(String S, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(S.charAt(i));
        }
    }

    static void palindrome(String S) {
        boolean dp[][] = new boolean[S.length()][S.length()];
        // 1.first we consider gap
        int start = 0;
        int maxlength = 1; // maxlength default 1 because one word in string wiil be palindrome
        for (int gap = 0; gap < S.length(); gap++) {
            for (int i = 0, j = gap; j < S.length(); i++, j++) {
                if (gap == 0) { // length 1 of all word is always substring
                    dp[i][j] = true;
                } else if (gap == 1) { // length 2 of all word if both word is same so it will palindrome like
                                       // cc,bb,aa,gg,ee
                    if (S.charAt(i) == S.charAt(j)) {
                        dp[i][j] = true;
                        start = i;
                        maxlength = 2;
                    } else
                        dp[i][j] = false;
                } else { // length of above 2 (1).we check stream first and last character and then check
                         // previous table means between this word
                         // if true then check lenght is greater than maxlenght or not.
                         // (2).if 1 point not true then go to else block
                    if (S.charAt(i) == S.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (gap > maxlength) {
                            start = i;
                            maxlength = gap;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        System.out.println("Longest Palindrome ");
        printPalindrome(S, start, start + maxlength);

        // TC=> n^2
        // SC=>n^2
    }

    public static void main(String[] args) {
        String S = "forgeeksskeegfor";
        palindrome(S);
    }
}
