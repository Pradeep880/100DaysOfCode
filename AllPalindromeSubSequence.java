public class AllPalindromeSubSequence {

    static long countPS(String str) {
        // Your code here
        int n = str.length();
        long dp[][] = new long[n + 1][n + 1];
        long num = 1000000007;
        for (int i = 0; i <= n; i++)
            dp[i][i] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = len + i - 1;
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = (1 + (dp[i][j - 1]) % num + (dp[i + 1][j]) % num) % num;
                else {
                    dp[i][j] = (((dp[i][j - 1]) % num + (dp[i + 1][j]) % num) - (dp[i + 1][j - 1] % num) % num) % num;
                }
            }
        }
        long res = (dp[0][n - 1] % num) % num;
        return res;
    }

    public static void main(String[] args) {
        String Str = "abcbca";
        System.out.println("Count of all Palindrome SubSequence is:" + countPS(Str));
    }
}