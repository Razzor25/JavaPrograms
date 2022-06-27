import java.util.*;
class MergeSort{
    public static void main(String args[])
    {
        int arr[]={1,12,2,3,0,2,3,4,5,6,-1,23,4,0};
        System.out.println("Before Sorting : "+Arrays.toString(arr));
        ms(arr,0,arr.length-1);
        System.out.println("After Sorting : "+Arrays.toString(arr));
    }
    static void ms(int arr[], int si , int ei )
    {
        if(si<ei)
        {
            int mid=(si+ei)/2;
            ms(arr,si,mid);
            ms(arr,mid+1,ei);
            merge(arr,si,mid,ei);
        }
    }
    static void merge(int arr[], int si , int mid , int ei)
    {
        int i=si;
        int j=mid+1;
        int k=si;
        int res[]=new int [ei+1];
        while(i<=mid && j<=ei)
        {
            if(arr[i]<=arr[j])
            res[k++]=arr[i++];
            else
            res[k++]=arr[j++];
        }
        while(i<=mid)
        {
            res[k++]=arr[i++];
        }
        while(j<=ei)
        {
            res[k++]=arr[j++];
        }
        for(int ele=si;ele<=ei;ele++)
        {
            arr[ele]=res[ele];
        }
    }
}