package com.company;

import java.util.Scanner;

public class Main {
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{7,8,9,1,2,3,4,5,6};


        //use this one for search method to find given target index
        System.out.println("Method 1 to find target in rotated array");
        System.out.println("searching in complete array");
        int result = search(arr,5);
        System.out.println("found: "+arr[result]+" at position: "+result);
        System.out.println("=");



        //finding pivot element then checking in two arrays i.e. {7,8,9} & {1,2,3,4,5,6}
        // here pivot is 1 (index=4)
        System.out.println("Method 2 to find target in rotated array using pivot");
        int pivot= searchpivot(arr);
        System.out.println("position "+ pivot );
        System.out.println("searching in left/right array using pivot");
        int detail = binarysearch(arr,5,0,pivot-1);
        if (detail==-1){
            detail= binarysearch(arr,5,pivot,arr.length-1);
        }
        System.out.println(detail);


    }
    public static int binarysearch(int[] nums,int target,int left, int right){
        int start=left;
        int end = right;
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

    public static int search(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            count++;
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    public static int searchpivot(int[] nums){
        int start=0;
        int end= nums.length-1;
        //7,8,9,1,2,3,4,5,6
        //0,1,2,3,4,5,6,7,8
        while (start<end){
            count++;
            int mid=start+(end-start)/2;
            System.out.println(nums[start]+"-"+ nums[end]+" "+nums[mid]);
            if (nums[mid]>nums[mid+1])
                return mid+1;
            else if (nums[mid]<nums[mid-1])
                return mid;

            if (nums[mid]<nums[start]) {
                // right side
                end = mid - 1;
            }
            else{
                //left side
                start=mid+1;
            }
        }
        return -1;
    }
}



    git init
    git add .
        git commit -m "comment"
        git push origin master