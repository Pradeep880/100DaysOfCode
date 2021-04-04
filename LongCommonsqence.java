/**
 * LongCommonsqence
 */
public class LongCommonsqence {
    static int recursiveAppraoch(String s1, String s2, int m, int n) {
        // This recursive approach using top down manner but Dp using bottom up manner
        if (n == 0 || m == 0)
            return 0;
        // It will check last character of both string is same or not
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + recursiveAppraoch(s1, s2, m - 1, n - 1);
        } else
            return Math.max(recursiveAppraoch(s1, s2, m, n - 1), recursiveAppraoch(s1, s2, m - 1, n));
    }

    static void SubSequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                // char c1 = s1.charAt(i);
                // char c2 = s2.charAt(j);
                if (i == s1.length() - 1 || j == s2.length() - 1)
                    dp[i][j] = 0;

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println("lenght of common subSequence of two string is:" + dp[0][0]);
    }

    public static void main(String[] args) {
        String s1 = "adfer";
        String s2 = "aedfd";
        int m = s1.length();
        int n = s2.length();
        // System.out.println("Longest common subSequence using recursion is:" +
        // recursiveAppraoch(s1, s2, m, n));
        SubSequence(s1, s2);
    }
}