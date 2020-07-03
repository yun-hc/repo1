package search;

public class LineSearch {
    public static void main(String[] args) {

        //线性查找

        int[] arr = {33,88,-2,34,1,9};
        int value = -2;
        int index = search(arr, value);
        if (index == -1){
            System.out.println("404");
        }else {
            System.out.println(value + "的下标为" + index);
        }
    }
    public static int search(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
