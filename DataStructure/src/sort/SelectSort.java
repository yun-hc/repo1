package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        //选择排序  时间复杂度O(n^2)

        int[] arr = {101,34,119,1};
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1 ; j < arr.length; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }



    }
}
