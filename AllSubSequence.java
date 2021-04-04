import java.util.*;

public class AllSubSequence {

    static List<String> a1 = new ArrayList<>();

    static void allSequence(String S, String ans) {
        if (S.length() == 0) {
            a1.add(ans);
            return;
        }
        // once we pick characeter
        allSequence(S.substring(1), ans + S.charAt(0));
        // don't pick
        allSequence(S.substring(1), ans);
    }

    public static void main(String[] args) {
        String S = "abc";
        allSequence(S, "");
        System.out.println("All SubSequence of String");
        System.out.println(a1);
    }
}