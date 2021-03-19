import java.util.*;
class Solution{
       static Node root=null;
       ArrayList<Node>array=new ArrayList<>();
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
    
    /* Constructed skewed binary tree is 
                10 
               / 
              8 
             / 
            7 
           / 
          6 
         / 
        5 
       /
      4 
          */
      void createNode(){
         root=new Node(10);
         root.left=new Node(8);
         root.left.left=new Node(7);
         root.left.left.left=new Node(6);
         root.left.left.left.left=new Node(5);
         root.left.left.left.left.left=new Node(4);
    }
    void PreOrder(Node node){
        if(node==null)
          return;
         System.out.print(node.data+"   ");
         PreOrder(node.left);
         PreOrder(node.right); 
    }

    void Inorder(Node node){
       if(node==null)
       return;
       Inorder(node.left);
       array.add(node);
       Inorder(node.right);
    }
    Node Balanced_Tree(ArrayList<Node>a1,int start,int end){
            if(start>end)
             return null;
             int mid=(start+end)/2;
            Node node=a1.get(mid);
            node.left=Balanced_Tree(a1,start,mid-1);
            node.right=Balanced_Tree(a1,mid+1,end);
            return node; 
    }
}
public class BST_to_Balanced{
    public static void main(String args[]){
        Solution s1=new Solution();
        s1.createNode();
        s1.Inorder(Solution.root);
        int n=s1.array.size();
       Solution.root=s1.Balanced_Tree(s1.array,0,n-1);
        System.out.println("PreOrder Travesal of Balanced Tree");
        s1.PreOrder(Solution.root);
    }
}