import java.util.*;
class mergesort{
    public static void main(String args[])
    {
        Node n1=new Node(30);
        Node n2=new Node(23);
        Node n3=new Node(28);
        Node n4=new Node(42);
        Node n5=new Node(11);
        Node h=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        // display(h);
        ms(h);
    }
    public static void ms(Node h)
    {
        display(h);
        if(h==null|| h.next==null)
        return;
        Node curr=h;
        Node mid=findMiddle(curr);
       
        
        ms(mid.next);
        mid.next=null;
        ms(curr);
        
        
    }
    //42 11
    //    
    //    s  f
    public static Node findMiddle(Node curr)
    {
       Node s=curr;
       Node f=curr;
        while(f!=null)
        {
            f=f.next;
            if(f!=null){
            s=s.next;
            f=f.next;
            }
        }
        return s;
         
    }
    public static void display(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("NULL");
    }
}
class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}