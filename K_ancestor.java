import java.util.*;

class Ancestor {
    static Node root = null;
    static int res;
    ArrayList<Integer> a1 = new ArrayList<>();

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

    // Node data Should be 1 to n
    void createNode() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }

    int findKAncestor(int pos, int k) {
        int count = 0;
        for (int i = pos - 1; i >= 0; i--) {
            count++;
            if (count == k) {
                return a1.get(i);
            }

        }
        return -1;
    }

    void generateArray(Node root, int ancestor[]) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        ancestor[root.data] = -1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            if (temp.left != null) {
                ancestor[temp.left.data] = temp.data;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                ancestor[temp.right.data] = temp.data;
                queue.add(temp.right);
            }
        }
    }

    int findKAncestor1(int data, int k, int n) {
        int ancestor[] = new int[n + 1];
        generateArray(root, ancestor);
        int count = 0;
        while (data != -1) {
            count++;
            data = ancestor[data];
            if (count == k)
                break;
        }
        return data;
    }
    // Another Approach
    // boolean Printk(Node root,int data,int k){
    // if(root==null)
    // return true ;
    // a1.add(root.data);
    // if(!Printk(root.left,data,k)){
    // return false;
    // }
    // if(! Printk(root.right,data,k)){
    // return false;
    // }
    // int f=0;
    // for(int j=a1.size()-1;j>=0;j--){
    // f=a1.get(j);
    // if(f==data){
    // res= findKAncestor(j,k);
    // System.out.print(k+"th Ancestor of "+data +" is:"+res);
    // return false;
    // }
    // }
    // // we have to remove current item after one path because we are moving
    // another path
    // int temp=a1.remove(a1.size()-1);
    // return true;
    // }
}

class K_ancestor {
    public static void main(String args[]) {
        Ancestor s1 = new Ancestor();
        s1.createNode();
        s1.a1 = new ArrayList<>();
        int k = 3;
        int data = 4;
        System.out.print(k + "th Ancestor of " + data + " is:" + s1.findKAncestor1(data, k, 5));
        // s1.Printk(Solution.root,5,2);
    }
}