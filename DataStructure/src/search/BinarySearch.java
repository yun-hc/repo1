package search;

import java.util.ArrayList;


public class BinarySearch {
    public static void main(String[] args) {
        //二分查找   只能用于查找有序数组


        int[] arr = {1,1,1,1,89,1000,1000,1000,1000,1111};
        ArrayList<Integer> list = new ArrayList<>();
        list = binarySearch(arr, 0, arr.length - 1, 1,list);
        System.out.println(list);
    }

    //可以查找多个相同的数
    public static ArrayList binarySearch(int[] arr, int left, int right, int finalValue, ArrayList list){
        System.out.println("使用了一次二分查找");
        if (left <= right){
            int mid = (left + right) / 2;//    mid = left + 1/2(right - left)
            if (arr[mid] < finalValue){
                list = binarySearch(arr, mid + 1, right, finalValue, list);
            }else if (arr[mid] > finalValue){
                list = binarySearch(arr, left, mid - 1, finalValue, list);
            }else {
                list.add(mid);
                list = binarySearch(arr, mid + 1, right, finalValue,list);
                list = binarySearch(arr, left, mid - 1,finalValue,list);
            }
        }
        return list;
    }

    /*public static int binarySearch(int[] arr, int left, int right,int finalValue ){
        if (left < right){
            int mid = (left + right) / 2;
            int index;
            if (arr[mid] < finalValue){
                index = binarySearch(arr, mid + 1, right, finalValue);
            }else if (arr[mid] > finalValue){
                index = binarySearch(arr, left, mid - 1,finalValue);
            }else {
                index = mid;
            }
            return index;
        }
        return -1;
    }*/
}
