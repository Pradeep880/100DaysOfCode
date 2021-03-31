// Java Program to Check if a string is a valid shuffle of two distinct strings
public class ValidShuffle {
    static boolean shuffle(String first, String second, String result) {
        if (first.length() + second.length() != result.length())
            return false;
        int i = 0, j = 0, k = 0;
        while (k != result.length()) {
            if (first.length() > i && first.charAt(i) == result.charAt(k))
                i++;
            else if (second.length() > j && second.charAt(j) == result.charAt(k))
                j++;
            else {
                return false;
            }
            k++;
        }
        // after accessing all characters of result
        // if either first or second has some characters left
        if (i < first.length() || j < second.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String result = "1XY2";
        String first = "XY";
        String second = "12";
        if (shuffle(first, second, result)) {
            System.out.println("String is valid shuffle of two distinct string");
        } else {
            System.out.println("String is not valid shuffle of two distinct string");
        }
    }
}
