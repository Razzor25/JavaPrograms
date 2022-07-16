import java.util.*;
public class LinearSort{
    public static void main(String args[])
    {
        int arr[]={1,3,4,6,2,0,9,8,1,2,3};
        int res[]=new int [arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int n=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                
                if(n>arr[j])
                {
                    int t=arr[j];
                    arr[j]=n;
                    arr[i]=t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}