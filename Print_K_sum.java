import java.util.*;
class Solution {
     static Node root=null;
       ArrayList<Integer>a1=new ArrayList<>();
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
        //             1
        //            /  \
        //           /    \
        //          3     -1
        //         / \    /  \
        //        2   1   4   5
        //            /  / \   \ 
        //           1   1  2   6
      
      void createNode(){
         root=new Node(1);
         root.left=new Node(3);
         root.right=new Node(-1);
         root.left.left=new Node(2);
         root.right.left=new Node(4);
         root.right.left.left=new Node(1);
         root.right.left.right=new Node(4);
         root.right.right=new Node(5);
         root.left.right=new Node(1);
         root.left.right.left=new Node(1);
         root.right.right.right=new Node(6);
        //  root.right.right.right=new Node(27);
    }
    void preOrder(Node root){
        if(root==null)
        return;
        System.out.print("  "+root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    void print_Path(int pos){
        for(int i=pos;i<a1.size();i++){
            System.out.print(a1.get(i)+"  ");
        }
        System.out.println();
    }
    void Printk(Node root,int k){
        if(root==null)
        return ;
        a1.add(root.data);
        Printk(root.left,k);
        Printk(root.right,k);
        int f=0;
        for(int j=a1.size()-1;j>=0;j--){
              f+=a1.get(j);
              if(f==k){
                  print_Path(j);
              }
        }
        // we have to remove current item after one path because we are moving another path
        int temp=a1.remove(a1.size()-1);
        // System.out.println("Remove:"+temp);
    }
}
class Print_K_sum{
public static void main (String args[]){
    Solution s1=new Solution();
    s1.createNode();
    s1.a1=new ArrayList<>();
    int k=5;
    // s1.preOrder(Solution.root);
    s1.Printk(Solution.root,k);
}
}