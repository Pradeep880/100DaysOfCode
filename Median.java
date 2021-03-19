class Solution{
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
     int  MorisTraversal() {
	   Node temp=null;
	   int count=0;
	  Node  current=root;
	   while(current!=null) {
		   if(current.left==null) {
			   count++;
			   System.out.print(current.data+"  ");
			   current=current.right;
		   }
		   else {   
			   temp=current.left;
//			   Now find rightmost element
			   while(temp.right!=null&&temp.right!=current)
				   temp=temp.right;
//			   Now we put current node in rightmost node's right because after doing this we can react current node
			   if(temp.right==null) {
				   temp.right=current;
				   //move to left subtree of current node and current node is available is temp's right 
				   current=current.left;
			   }
//				now when we changed node here we revert this changed means again do same (jaisa phle tha waise hi kr denge)
			   else {
				   temp.right=null;
				   count++;
				   System.out.print(current.data+"  ");
				   current=current.right;
			   }
			   
		   } //end else current.left!=null
	   }    //end while
	   return count;
   }
   //   Find the median of BST in o(n) time and O(1) space
   int FindMedian() {
	   Node prev=null,ptr;int Currcount=0;
	   int count=MorisTraversal();
	   Node current=root;
	   System.out.println("Count:"+count);
	   while(current!=null) {
		     if(current.left==null) {
		    	 Currcount++;
		    	 if(count%2!=0&&Currcount==(count+1)/2) {
		    		 return current.data;
		    	 }
		    	 else if(count%2==0&&Currcount==(count/2)+1) {
//                   System.out.println("Median:"+(prev.data+current.data)/2);		    		 
		    		 return (prev.data+current.data)/2;
		    	 }
		    	 prev=current;
		    	 current=current.right;
		     }
		     else {
		    	 ptr=current.left;
		    	 while(ptr.right!=null&&ptr.right!=current) {
		    		 ptr=ptr.right;
		    	 }
		    	 if(ptr.right==null) {
		    		 ptr.right=current;
		    		 current=current.left;
		    	 }else if(ptr.right!=null) {
		    		 ptr.right=null;
		    		 Currcount++;
		    		 if(count%2!=0&&Currcount==(count+1)/2) {
			    		 return current.data;
			    	 }
			    	 else if(count%2==0&&Currcount==(count/2)+1) {
//			             System.out.println("Median:"+(prev.data+current.data)/2);	
			    		 return (prev.data+current.data)/2;
			    	 }
		    		 prev=current;
		    		 current=current.right;
		    	 }
		     }
	   }
	   return prev.data;
   }
}
class Median{
            public static void main(String args[]){
                Solution s1=new Solution();
                s1.createNode();
               System.out.print("Median of Binary Tree:" +s1.FindMedian());
            }
}