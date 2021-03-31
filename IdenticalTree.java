
/**
 * InnerIdenticalTree
 */
class InnerIdenticalTree {
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
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return ((p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}

public class IdenticalTree {
    public static void main(String[] args) {
        InnerIdenticalTree i1 = new InnerIdenticalTree();
        i1.createNode1();
        i1.createNode2();
        if (i1.isSameTree(InnerIdenticalTree.root1, InnerIdenticalTree.root2)) {
            System.out.println("Trees are Identical");
        } else {
            System.out.println("Tree are not Identical");
        }
    }
}
