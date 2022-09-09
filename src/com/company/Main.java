package com.company;

import java.util.Scanner;

public class Main {
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,};
        //let target be 5
        int position = binarysearch(arr,5);

        System.out.println("Found element 5 at position: "+position);

    }
    public static int binarysearch(int[] nums,int target){
        int start=0;
        int end = nums.length-1;
        //1234
         while (start<=end){
             int mid = (start+end)/2;
             if (nums[mid]==target){
                 return  mid;
             }
             else if (target< nums[mid]){
                 end=mid-1;
             }
             else
                 start = mid+1;

         }
         return -1;
    }



}
