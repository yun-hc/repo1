package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        //基数排序(筒子法)
//        int[] arr = {53,3,542,748,14,214};

        //测试速度
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println(format1);

        radixSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println(format2);
    }

    public static void radixSort(int[] arr){
        int[][] bucket = new int[10][arr.length];//防止溢出

        int[] bucketElementCounts = new int[10];//记录每个筒子的数据总数

        //找出最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for (int l = 0; l < maxLength; l++) {
            for (int j = 0; j < arr.length; j++) {  /*幂次方不是10^l */
                int digitOfElement = arr[j] / ((int)Math.pow(10,l)) % 10; //妙啊 取个位数 十位数 百位数
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //取出数据
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                for (int i = 0; i < bucketElementCounts[k]; i++) {
                    arr[index] = bucket[k][i];
                    index++;
                }
                bucketElementCounts[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }




    }
}
