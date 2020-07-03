package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        //希尔排序  是插入排序的优化  也叫缩小增量排序
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        //交换式  希尔+冒泡

        /*int temp;
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                for (int j = i - group; j >= 0; j -= group) {  //共group个组
                    if (arr[j] > arr[j + group]) {
                        //交换
                        temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                        //这一步像冒泡排序
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }*/

        //交换式  希尔+冒泡   反向
        /*int temp;
        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = 0; i < arr.length - group; i++) {
                for (int j = i + group; j < arr.length; j += group) {
                    if (arr[j] > arr[j - group]) {
                        temp = arr[j];
                        arr[j] = arr[j - group];
                        arr[j - group] = temp;
                    }
                }
                System.out.println(group);
                System.out.println(Arrays.toString(arr));
            }
        }*/


        //移位式  希尔+插入


        for (int group = arr.length / 2; group > 0; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - group >= 0 && temp < arr[j - group]) {
                    arr[j] = arr[j - group];
                    j -= group;
                }
                arr[j] = temp;

//                System.out.println(Arrays.toString(arr));
            }
        }








    }
}
