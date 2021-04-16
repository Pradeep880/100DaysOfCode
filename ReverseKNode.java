public class ReverseKNode{
  Node ReverseK(Node head,int k) {
	  int count=0;
	  Node backup;
	  Node current=head;
	  Node prev=null;
	  while(current!=null&&count<k) {
		  current.prev=current.next;
		  backup=current.next;
		  current.next=prev;
		  prev=current;
		  current=backup;
		  count++;
	  }
	  if(current!=null) {
		  head.next=ReverseK(current,k);
		  head.next.prev=head;
	  }
	  return prev;
  }
}