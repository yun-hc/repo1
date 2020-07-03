package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        //斐波那契查找

        int[] arr = {1,8,10,89,1000,1234};
        int i = fibSerach(arr, 89);
        System.out.println(i);

    }
    public static int maxSize = 20;
    //获取斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;

    }

    /**
     *
     * @param a   数组
     * @param key  查找的值
     * @return
     */
    public static int fibSerach(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;//斐波那契分割下标
        int mid = 0;
        int[] f = fib();
        while (a.length > f[k] - 1){
            k++;
        }
        //扩充原数组至斐波那契数组的长度，再用原数组最后一个数填充
        int[] temp = Arrays.copyOf(a,f[k] - 1);
        for (int i = high + 1; i < temp.length; i++){
            temp[i] = a[high];
        }

        while (low <= high){
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){
                high = mid - 1;
                k--;//对前半部分继续拆分
            }else if(key > temp[mid]){
                low = mid + 1;
                k -= 2;//对后半部分继续拆分
            }else{
                if (mid <= high) {
                    return mid;
                }else {
                    return high;
                }
            }
        }

        return -1;


    }

}

