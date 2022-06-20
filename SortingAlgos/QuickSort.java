package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

        public static void main(String[]args){
        String s = "abuzyxdefABCgAaAaA";
        char[] carr = s.toCharArray();
        String arr[] = new String[carr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(carr[i]);
        }
//        System.out.println(Arrays.toString(arr));
        qs(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareToIgnoreCase(arr[i - 1]) == 0) {
                if (arr[i].compareTo(arr[i - 1]) > 0) {
                    swap(arr, i, i - 1);
                    System.out.println(Arrays.toString(arr) + " Here The " + i + " is Swapped with " + (i - 1));
                    if(i>2){
                        i-=2;
                    }
                    else{
                        i--;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
        static void qs (String arr[],int si, int ei)
        {
            if (si < ei) {
                int split = part(arr, si, ei);
                qs(arr, si, split - 1);
                qs(arr, split + 1, ei);
            }
        }
        static int part (String arr[],int si, int ei)
        {
            int p = si + (ei - si) / 2;
            int i = si;
            int j = ei;
            while (i < j) {
                while (arr[i].compareToIgnoreCase(arr[p]) <= 0) {
                    i++;
                    if (i > ei) {
                        swap(arr, p, j);
                        return j;
                    }
                }
                while (arr[j].compareToIgnoreCase(arr[p]) > 0)
                    j--;

                if (i < j) {
                    swap(arr, i, j);
                    if (j == p) {
                        p = i;
                    }
                }
            }
            swap(arr, p, j);
            return j;

        }
        static void swap (String arr[],int a, int b)
        {
            String t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
    }


