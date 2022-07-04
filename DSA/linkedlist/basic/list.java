import java.util.*;

class list
{
    public static void main(String args[]){
        node n1=new node(1);
        node n2=new node(2);
        node n3=new node(4);
        node h=n1;
        n1.next=n2;
        n2.next=n3;
        display(h);
    }
    static void display(node h)
    {
        while(h!=null)
        {
            System.out.println(h.data);
            h=h.next;
        }
    }
}
class node
{
 int data;
 node next;
 node(int data)
    {
        this.data=data;
    }
}

