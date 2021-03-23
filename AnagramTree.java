import java.util.*;

class Anagram {
    static Node root1 = null;
    static Node root2 = null;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    void createNode1() {
        root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
    }

    void createNode2() {
        root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.left.left = new Node(5);
        // root2.left.right = new Node(4);
    }

    boolean anagramTree(Node root1, Node root2) {

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        queue1.add(root1);
        queue2.add(root2);
        while (true) {
            int n1 = queue1.size();
            int n2 = queue2.size();
            if (n1 != n2)
                return false;
            if (n1 == 0)
                break;
            ArrayList<Integer> a1 = new ArrayList<>();
            ArrayList<Integer> a2 = new ArrayList<>();
            while (n1 > 0) {
                Node temp1 = queue1.peek();

                queue1.remove();
                if (temp1.left != null)
                    queue1.add(temp1.left);
                if (temp1.right != null)
                    queue1.add(temp1.right);
                Node temp2 = queue2.peek();

                queue2.remove();
                if (temp2.left != null)
                    queue2.add(temp2.left);
                if (temp2.right != null)
                    queue2.add(temp2.right);
                n1--;
                a1.add(temp1.data);
                a2.add(temp2.data);
            }
            Collections.sort(a1);
            Collections.sort(a2);
            System.out.println(a1);
            System.out.println(a2);
            if (!a1.equals(a2)) {
                return false;
            }
        }
        return true;
    }
}

public class AnagramTree {
    public static void main(String[] args) {
        Anagram tree = new Anagram();
        tree.createNode1();
        tree.createNode2();
        if (tree.anagramTree(Anagram.root1, Anagram.root2)) {
            System.out.println("Trees Are Anagrams");
        } else
            System.out.println("Trees Are not Anagrams");
    }
}
