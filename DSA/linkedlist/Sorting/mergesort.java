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
        display(h);
        // System.out.println(t.data);
        h=ms(h);
        display(h);
        
    }
    public static Node ms(Node h)
    {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }
 
        // get the middle of the list
        Node middle = findMiddle(h);
        Node nextofmiddle = middle.next;
 
        // set the next of middle node to null
        middle.next = null;
 
        // Apply mergeSort on left list
        Node left = ms(h);
 
        // Apply mergeSort on right list
        Node right = ms(nextofmiddle);
 
        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
    public static Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    public static void display(Node ref)
    {
        Node curr=ref;
        while(curr!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }
    public static Node findMiddle(Node head)
    {
       if (head == null)
            return head;
 
        Node slow = head, fast = head.next;
 
       while(fast!=null)
       {
        fast=fast.next;
        if(fast!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
       }
        return slow;
        
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