class Solution {
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
    Node LCA(Node root,int n1,int n2){
        if(root==null)
        return null;
        if(root.data==n1||root.data==n2){
            return root;
        }
        Node left_lca=LCA(root.left,n1,n2);
        Node right_lca=LCA(root.right,n1,n2);
        if(left_lca!=null&&right_lca!=null){
            return root;
        }
        return (left_lca!=null)? left_lca:right_lca;
    }
    int solve(Node root,int n ){
        if(root==null)
        return 0;
        if(root.data==n)
        return 1;
        int a=solve(root.left,n);
        int b=solve(root.right,n);
        if(a==0&&b==0)
          return 0;
          else
            return a+b+1;
    }
    int findDist(Node root, int a, int b) {
    
        //   First we find LCA then
        Node lca=LCA(root,a,b);
        // distance from LCA to node A
        int x=solve(lca,a);
        // distance from LCA to node B
        int y=solve(lca,b);
        // we will substract two(2) because for finding distance form LCA to node a and b we were consider root also
        return x+y-2;
        
    }
}
class DistanceTwoNodes{
            public static void main(String args[]){
                Solution s1=new Solution();
                s1.createNode();
                int a=10;
                int b=27;
                System.out.print("Distance between "+a+" and "+ b+" is:"+s1.findDist(Solution.root,a,b));
            }
}