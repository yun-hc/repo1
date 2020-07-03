package recursion;

public class RecursionDemo01 {
    public static void main(String[] args) {
        test(5);
        //递归打印

        //递归阶乘
        System.out.println(factorial(5));
    }

    private static int factorial(int i) {
        if (i == 1){
            return 1;
        }else {
            return i * factorial(i - 1);
        }
    }

    private static void test(int i) {
        if (i > 2){
            test(i - 1);
        }
        System.out.println("i=" + i);
    }
}
