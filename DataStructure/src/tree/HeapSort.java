package tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
       /* int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));*/


       //测试速度
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println(format1);

        heapSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println(format2);
    }

    /**
     * 堆排序
     * 升序
     * @param arr
     */
    public static void heapSort(int[] arr){
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 将数组调整成大顶堆
     * @param arr 数组
     * @param i   非叶子节点的索引
     * @param length  调整元素的个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k; ///!!!!
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}
