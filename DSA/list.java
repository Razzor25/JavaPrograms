package LinkedList;
import java.util.*;

class list{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a[]=new int [5107];
        for(int i=0;i<a.length;i++)
        {
            a[i]=sc.nextInt();
        }

        int c=0;
        for(int i=0;i<a.length;i++)if(c+a[i]%2==0)c++;
        System.out.println(c);

    }
}

