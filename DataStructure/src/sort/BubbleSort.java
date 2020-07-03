package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //冒泡排序  时间复杂度：O(n^2)


        // 3，9，-1， 10， -2
        int arr[] = {3,9,-1,10,20};
        /*int temp;
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }*/

        //优化
        int temp;
        for (int j = 1; j < arr.length; j++) {
            int count = 0; //记录交换次数
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i]>arr[i+1]){
                    count++;//交换一次加一次
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (count == 0){
                System.out.println("冒泡排序完毕！");
                break;
            }else {
                System.out.println("第"+j+"次排序一共交换了"+count+"次");
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
