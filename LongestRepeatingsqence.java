/**
 * LongestRepeatingsqence
 */
// Given a string str, find length of the longest repeating subseequence such
// that the two subsequence don’t have same string character at same position,
// i.e., any i’th character in the two subsequences shouldn’t have the same
// index in the original string.
public class LongestRepeatingsqence {

    // We can also do it 1.Store all subSequence of string in pair(with index and
    // character) and then find duplicate and
    // then find longest Repeating SubSquence but time complexity of this approach
    // will more(2^n)
    // we use LCS(Longest common SubSequence wiht does not have same index)

    static int LongestRepeatingSubsequence(String str) {
        // code here
        int n = str.length();
        // we use string twice because we are using LCS
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                // if char of str(ith) and char of str2(jth) is equal and
                // index of str1 and str2 is not equal so we consider one subsequence
                else if (str.charAt(i - 1) == str.charAt(j - 1) && i - 1 != j - 1)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String str = "abcbc";
        System.out.println("Longest Repeating subSequence is :" + LongestRepeatingSubsequence(str));
    }
}