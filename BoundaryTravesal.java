import java.util.*;
class Solution
{
   static Node root=null;
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
    ArrayList<Integer>a1=new ArrayList<>();
    void LeftSubtree(Node root){
        if(root==null)
        return;
        if(root.left==null&&root.right==null)
          return;
          if(root.left!=null){
               a1.add(root.data);
              LeftSubtree(root.left);
          }else if(root.right!=null){
              a1.add(root.data);
              LeftSubtree(root.right);
          }
    }
    void RightSubtree(Node root){
        if(root==null)
        return;
        if(root.left==null&&root.right==null)
          return;
          if(root.right!=null){
           
              RightSubtree(root.right);
                 a1.add(root.data);
          }else if(root.left!=null){
            RightSubtree(root.left);
             a1.add(root.data);
          }
    }
    
    void LeafNode(Node root){
        if(root==null)
          return;
          if(root.left==null&&root.right==null){
              a1.add(root.data);
          }
          LeafNode(root.left);
          LeafNode(root.right); 
    }
	ArrayList <Integer> printBoundary(Node root)
	{
	    a1=new ArrayList<>();
	    a1.add(root.data);
	    LeftSubtree(root.left);
	    LeafNode(root);
	   // LeafNode(root.right);
	    RightSubtree(root.right);
	    return a1;
	}
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
class BoundaryTravesal{
 public static void main(String args[]){
       Solution b1=new Solution();
       b1.createNode();
       ArrayList<Integer>array=b1.printBoundary(Solution.root);
       System.out.println("Boundary Traversal of Binary Tree");
       System.out.print(array);
   }
}