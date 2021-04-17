package Avl;

//import BST.Binary_Operation.Node;

public class Avl_all {
	static public Node root;
   public class Node{
	   int data;
	   Node left;
	   Node right;
	   int h;
	   Node(int data){
		   this.data=data;
		   this.h=1;   //when new node created so height = 1
	   }
   }
   int Height(Node root) {
	   if(root==null)
		   return 0;
	   return root.h;
   }
   int getbalance(Node root) {
	   if(root==null)
		   return 0;
	   return Height(root.left)-Height(root.right);
   }
  
   Node RightRotation(Node root) {
	   Node temp=root.left;
	   Node r=temp.right;
	   root.left=r;
	   temp.right=root;
//	   Update Height   (First update height of root)
	   root.h=Math.max(Height(root.left),Height(root.right))+1;
	   temp.h=Math.max(Height(temp.left),Height(temp.right))+1;  
	   return temp;
   }
   Node LeftRotation(Node root) {
	   Node temp=root.right;
	   Node r=temp.left;
	   root.right=r;
	   temp.left=root;
//	   Update Height   (First update height of root)
	   root.h=Math.max(Height(root.left),Height(root.right))+1;
	   temp.h=Math.max(Height(temp.left),Height(temp.right))+1;  
	   return temp;
   }
   Node Insertion(Node root,int item) {
	   if(root==null) {
		   Node newnode=new Node(item);
		   return newnode;
	   }else if(root.data<item) {
		   root.right=Insertion(root.right,item);
	   }else if(root.data>item) {
		   root.left=Insertion(root.left,item);
	   } else {
			   System.out.println("Duplicate value in not allowed in BST");
			   return null;
		   }
	   root.h=Math.max(Height(root.left),Height(root.right))+1;
	   int balance=getbalance(root);
//	   left left case(Right Rotation)
	   if(balance>1&&item<root.left.data) {
		   System.out.println("Left -Left case");
		   return  RightRotation(root);
//		   Right Right case (Left Rotation)
	   }else if(balance<-1&&item>root.right.data) {
		   System.out.println("Right Right case");
		   return LeftRotation(root);   
//		   Left Right case(First Left Rotation then Right Rotation)
	   }else if(balance>1&&item>root.left.data) {
		   System.out.println("Left -Right case");
		   root.left=LeftRotation(root.left);
		   return RightRotation(root);
//		   Right Left case(First Right Rotation and the  Left Rotation)
	   }else if(balance<-1&&item<root.right.data) {
		   System.out.println("Right -Left case");
		   root.right=RightRotation(root.right);
		   return LeftRotation(root);
	   }
	   return root;
   }
   Node Predeccer(Node root) {
		  Node temp=root.left;
//		  Node prev=root; 
		  while(temp.right!=null) {
//			  prev=temp;
			  temp=temp.right;
		  }
//		  prev.right=null;
		  return temp;
	  }
	  Node Succeror(Node root) {
		  Node temp=root.right;
		  Node prev=root;
		  while(temp.left!=null) {
			prev=temp;
			  temp=temp.left;
		  }
		  return temp;
	  }
	  Node Delete(int item,Node root) {    
		  if(root==null) {
			  System.out.println("Data is not present in this tree");
			  return null;
		  }
		  if(root.data==item) {
			  if(root.left==null&&root.right==null) {
				  System.out.println("Deleted data:"+root.data);
				  return null;
			  }if(root.left!=null&&root.right==null) {
				  Node temp=root.left;
				  System.out.println("Deleted data:"+root.data);
				  return temp;
			  }if(root.right!=null&&root.left==null) {
				  Node temp=root.right;
				  System.out.println("Deleted data:"+root.data);
				  return temp;
			  }if(root.right!=null&&root.left!=null) {
				  Node predeccer=Predeccer(root);
				  System.out.println("Deleted data:"+root.data);
				  root.data=predeccer.data;
				  root.left=Delete(predeccer.data,root.left);
				  return root;		  
			  }
		  }else if(item<root.data) {
			 root.left= Delete(item,root.left);
		  }else {
			  root.right=Delete(item,root.right);
		  }
		   root.h=Math.max(Height(root.left),Height(root.right))+1;
		   int balance=getbalance(root);
//		   left left case(Right Rotation)
		   if(balance>1&&item<root.left.data) {
			   System.out.println("Left -Left case");
			   return  RightRotation(root);
//			   Right Right case (Left Rotation)
		   }else if(balance<-1&&item>root.right.data) {
			   System.out.println("Right Right case");
			   return LeftRotation(root);   
//			   Left Right case(First Left Rotation then Right Rotation)
		   }else if(balance>1&&item>root.left.data) {
			   System.out.println("Left -Right case");
			   root.left=LeftRotation(root.left);
			   return RightRotation(root);
//			   Right Left case(First Right Rotation and the  Left Rotation)
		   }else if(balance<-1&&item<root.right.data) {
			   System.out.println("Right -Left case");
			   root.right=RightRotation(root.right);
			   return LeftRotation(root);
		   }
		   return root;
	  }
   void InOrder(Node root) {
	   if(root==null)
		   return;
	   if(root.left!=null) {
		   InOrder(root.left);
	   }
	   System.out.print(root.data+" ");
	   if(root.right!=null) {
		   InOrder(root.right);
	   }
   }
   void PreOrder(Node root) {
	   if(root==null)
		   return;
	   System.out.print(root.data+" ");
	   if(root.left!=null) {
		   InOrder(root.left);
	   }
	
	   if(root.right!=null) {
		   InOrder(root.right);
	   }
   }
}

