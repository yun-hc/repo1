package sort;

import java.util.Arrays;

           //插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {17,3,25,14,20,9};
        int insertVal;
        int insertIndex;//定义变量在外边，节约时间

        for (int i = 1; i < arr.length; i++) {
            System.out.println("第"+i+"轮插入");
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
                System.out.println(Arrays.toString(arr));
            }
            arr[insertIndex+1] = insertVal;
            System.out.println(Arrays.toString(arr));
        }
    }
}
