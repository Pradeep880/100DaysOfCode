
class PalindromeString {
    static boolean isPlaindrome(String S) {
        // code here
        int n = S.length() - 1;
        int l = 0;
        while (l <= n) {
            if (S.charAt(l) != S.charAt(n))
                return false;
            l++;
            n--;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "abba";
        if (isPlaindrome(S)) {
            System.out.println("String is Plaindrome");
        } else {
            System.out.println("String is not  Plaindrome");
        }
    }
};