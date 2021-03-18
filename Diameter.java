class Solution {
     static Node root=null;
       static int max=Integer.MIN_VALUE;
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    int helper(Node root){
        if(root==null)
        return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        max=Math.max(max,l+r+1);
        return Math.max(l,r)+1;
    }
    /* Complete the function to get diameter of a binary tree */
    int diameter(Node root) {
        // Your code here
        if(root==null)
        return -1;
        max=Integer.MIN_VALUE;
        int x=helper(root);
        return max;
    }
        //             20
        //            /  \
        //           8    22
        //          / \      \
        //         4   12      25
        //            /   \      \ 
        //           10    14     27
      
      void createNode(){
         root=new Node(20);
         root.left=new Node(8);
         root.right=new Node(22);
         root.left.left=new Node(4);
         root.right.right=new Node(25);
         root.left.right=new Node(12);
         root.left.right.left=new Node(10);
         root.left.right.right=new Node(14);
         root.right.right.right=new Node(27);
    }
}
class Diameter{
public static void main (String args[]){
    Solution s1=new Solution();
    s1.createNode();
    System.out.print("Diameter Of Binary Tree:"+s1.diameter(Solution.root)); 
}
}
