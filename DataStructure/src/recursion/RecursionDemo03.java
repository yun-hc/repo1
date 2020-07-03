package recursion;
//八皇后
public class RecursionDemo03 {
    int max = 8;
    int[] arr = new int [max];
    int count = 0;
    int judgecount = 0;
    public static void main(String[] args) {
        RecursionDemo03 queue8 = new RecursionDemo03();
        queue8.check(0);
        System.out.println("解法总数：" + queue8.count);
        System.out.println("判断总数：" + queue8.judgecount);
    }

    //////  重点理解
    public void check(int n){
        if (n == max){
            show();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }


    }
     ////   arr[i] = j  表示 第i+1个皇后摆放在第i+行第j+1列
    public boolean judge(int n){ //n表示第n+1个皇后
        judgecount++;
        for (int i = 0; i < n; i++) {
            //表示不是同一列，也不在同一个直线
            if (arr[i] == arr[n] || arr[i] == arr[n]-(n-i) || arr[i] == arr[n]+(n-i)){
                return false;
            }
        }
        return true;
    }

    public void show(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
