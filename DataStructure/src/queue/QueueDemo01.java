package queue;

import java.util.Scanner;

public class QueueDemo01 {
    public static void main(String[] args) {
        //数组模拟队列
        ArrayQueue arrayQueue = new ArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列的头元素");
            char key = scanner.next().charAt(0);//接受输入的字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你想添加的数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = arrayQueue.getQueue();
                        System.out.println("取出的数据为："+ i);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.println("队列的头数据为："+ i);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;

            }
        }
        System.out.println("程序退出");

    }
}

class ArrayQueue{
    private int maxSize;//最大容量
    private int front;//队列头（第一个元素的前一个位置）
    private int rear;//队列尾（最后一个元素）
    private int[] arr;//数组(模拟队列)

    //构造方法
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpyt(){
        return rear == front;
    }

    public void addQueue(int i){
        if (isFull()){
            System.out.println("队列已满！");
        }else {
            rear++;
            arr[rear] = i;
        }
    }

    public int getQueue(){
        if (isEmpyt()){
            throw new RuntimeException("队列空!");
        }else{
            front++;
            return arr[front];
        }
    }
    public void showQueue(){
        if (isEmpyt()){
            System.out.println("队列空！");
        }else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i + ":" + arr[i]);
            }
        }
    }

    public int headQueue(){
        if (isEmpyt()){
            throw new RuntimeException("队列空!");
        }
        return arr[front + 1];
    }
}