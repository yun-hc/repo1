package sort;

import java.util.Arrays;

public class MergeSort {
    public  static int count = 0;
    public static void main(String[] args) {
        //归并排序    和快速排序一样采用了分治算法

        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length - 1, temp);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));



    }

    public static void sort(int[] arr, int left, int right, int temp[]) {
        count++;
        System.out.println(left +"+"+ right);
        if (left < right) {//分治
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
        //合并方法
    public static void merge(int[] arr, int left, int mid,int right,int temp[]){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //temp长度与原数组相同，每次合并都只是使用temp的其中一部分
        t = 0;//刷新指针，指到temp的第一位
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];  //其实t可以等于left；
            t++;
            tempLeft++;
        }



    }
}
