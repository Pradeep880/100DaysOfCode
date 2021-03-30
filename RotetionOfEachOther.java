public class RotetionOfEachOther {
    static boolean check(String s1, String s2) {
        String temp = s1 + s1;
        System.out.println(temp);
        if (s1.length() == s2.length() && (temp.indexOf(s2) != -1))
            return true;
        return false;
        // return ((s1.length() != s2.length()) && ((s1 + s1).indexOf(s2) != -1));
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        if (check(s1, s2)) {
            System.out.println("String is rotetion of each other");
        } else
            System.out.println("String is not rotetion of each other");
    }
}
