package search;

import java.util.ArrayList;

public class InterpolationSearch {
    public static void main(String[] args) {

        //插值查找 类似与二分查找；  用于查找均匀有序的数组
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = InterpolationSearch(arr, 0, arr.length - 1, 18,list1);
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2 = BinarySearch.binarySearch(arr, 0, arr.length - 1, 18,list2);
        System.out.println(list2);



    }

    private static ArrayList InterpolationSearch(int[] arr, int left, int right, int finalValue, ArrayList list){
        System.out.println("使用了一次插值查找");
        if (left < right){
            int mid = left + (right - left) * (finalValue - arr[left]) / (arr[right] - arr[left]);//数组均匀有序，估算位置
            if (mid > right || mid < left){
                return list;
            }
            if (arr[mid] < finalValue){
                list = InterpolationSearch(arr, mid + 1, right, finalValue, list);
            }else if (arr[mid] > finalValue){
                list = InterpolationSearch(arr, left, mid - 1, finalValue, list);
            }else {
                list.add(mid);
                list = InterpolationSearch(arr, mid + 1, right, finalValue,list);
                list = InterpolationSearch(arr, left, mid - 1,finalValue,list);
            }
        }else if (left == right){
            if (arr[left] == finalValue){
                list.add(left);
            }
        }
        return list;
    }
}
