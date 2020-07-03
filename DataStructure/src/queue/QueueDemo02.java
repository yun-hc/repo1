package queue;

import java.util.Scanner;

public class QueueDemo02 {
    public static void main(String[] args) {
        //数组模拟环形队列
        CircleArrayQueue cirleArrayQueue = new CircleArrayQueue(4);
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
                    cirleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入你想添加的数：");
                    int value = scanner.nextInt();
                    cirleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int i = cirleArrayQueue.getQueue();
                        System.out.println("取出的数据为："+ i);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = cirleArrayQueue.headQueue();
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

class CircleArrayQueue{
    private int maxSize;//最大容量
    private int front;//队列头(第一个元素)
    private int rear;//队列尾（最后一个元素的后一个位置）
    private int[] arr;//数组(模拟队列)

    //构造方法
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;////重点！！！
    }

    public boolean isEmpyt(){
        return rear == front;
    }

    public void addQueue(int i){
        if (isFull()){
            System.out.println("队列已满！");
        }else {
            arr[rear] = i;
            rear = (rear + 1) % maxSize;//重点！！！
        }
    }

    public int getQueue(){
        if (isEmpyt()){
            throw new RuntimeException("队列空!");
        }else{
            int i = arr[front];
            front = (front + 1) % maxSize;
            return i;
        }
    }
    public void showQueue(){
        if (isEmpyt()){
            System.out.println("队列空！");
        }else {
            for (int i = front; i < front + ((rear - front + maxSize) % maxSize); i++) {
                System.out.println("arr["+ (i % maxSize) +"] = " + arr[i % maxSize]);
            }
        }
    }

    public int headQueue(){
        if (isEmpyt()){
            throw new RuntimeException("队列空!");
        }
        return arr[front];
    }
}