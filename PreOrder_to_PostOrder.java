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
          static class Index{
               static  int i=0;
            }
   
            Node preOrder(int pre[],int min,int max,int size){
            if(Index.i>=size){
                return null;
            }
            
                Node root=null;
            if(min<pre[Index.i]&&max>pre[Index.i]){
                    root=new Node(pre[Index.i]);
                    Index.i=Index.i+1;
                    if(Index.i<size){
                    root.left=preOrder(pre,min,root.data,size);
                }
                if(Index.i<size){
                    root.right=preOrder(pre,root.data,max,size);
                }
            }

                return root;
            }
            Node constructTree(int pre[], int size) {
                
                //Your code here
                int min=Integer.MIN_VALUE;
                int max=Integer.MAX_VALUE;
                Index.i=0;
                Node root=preOrder(pre,min,max,size);
                return root;
            } 
            void PostOrder(Node root){
                if(root==null)
                return;
                PostOrder(root.left);
                PostOrder(root.right);
                System.out.print(root.data+"  ");
            }

}
class PreOrder_to_PostOrder{
    public static void main(String args[]){
        Solution s1=new Solution();
        int pre[]= {40,30,35,80,100};
        int size=pre.length;
        Solution.root=s1.constructTree(pre,size);
        s1.PostOrder(Solution.root);
    }
}