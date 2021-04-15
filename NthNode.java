public class NthNode{
    static Node root=null;
    class Node{
        Node next;
        int data;
        Node(int data){
           this.data=data;
           next=null;
        }
    }
    Node insert(){
        root=new Node(1);
        root.next=new Node(2);
        root.next.next=new Node(3);;
        root.next.next.next=new Node(4);
        root.next.next.next.next=new Node(5);
        root.next.next.next.next.next=new Node(6);
        root.next.next.next.next.next.next=new Node(7);
    }
    Node Nth(int k){
         Node f=root;
         Node last=root;
         Node current=root;
         int i=0;
        while(i<k&&current!=null){
            current=current.next;
        }
        last=current;
        while(last.next!=null){
            last=last.next;
            f=f.next;
        }
       System.out.println("Nth Element from last Node"+f.data);
    }
}