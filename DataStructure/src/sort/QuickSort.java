package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //快速排序   冒泡排序的改进
        int[] arr = {-9,78,0,23,-567,70,0};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int l = left;
            int r = right;
            int mid = arr[l];
            while (l < r){
                while(l < r && arr[r] >= mid){
                    r--;
                }
                if (l < r){
                    arr[l++] = arr[r];
                }
                while(l < r && arr[l] < mid){
                    l++;
                }
                if (l < r){
                    arr[r--] = arr[l];
                }
            }
            arr[l] = mid;
            quickSort(arr,left,l - 1);
            quickSort(arr,l + 1,right);
        }
    }

    /*public static void quickSort(int[] arr, int left, int right){
        //以中间数为基准
        int l = left;
        int r = right;
        int mid = arr[(l + r) / 2];
        int temp;
        while (l < r) {
            while (arr[l] < mid) {//将mid左边的值与mid比较，比mid大的放右边
                l++;
            }
            while (arr[r] > mid) {//将mid右边的值与mid比较，比mid小的放左边
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == mid){ //避免有其他值等于中间值
                r--;
            }
            if (arr[r] == mid){//避免有其他值等于中间值,导致死循环
                l++;
            }
        }

            if (l == r){
                l++;
                r--;
            }
            //向左递归
            if (left < r){
                quickSort(arr, left, r);
            }
            //向右递归
            if (right > l){
                quickSort(arr,l,right);
            }
    }*/
}
