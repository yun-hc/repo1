package stack;

public class ArrayStackDemo01 {
    public static void main(String[] args) {
        /*ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(2);
        arrayStack.push(4);
        arrayStack.push(6);
        arrayStack.push(6);
        arrayStack.list();
        try {
            System.out.println(arrayStack.pop());
            System.out.println(arrayStack.pop());
            System.out.println(arrayStack.pop());
            System.out.println(arrayStack.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/

        LinkedlistStack linkedlistStack = new LinkedlistStack(3);
        linkedlistStack.push(1);
        linkedlistStack.push(3);
        linkedlistStack.push(5);
        linkedlistStack.push(7);
//        linkedlistStack.show();
        linkedlistStack.pop();
        linkedlistStack.pop();
        linkedlistStack.pop();
        linkedlistStack.pop();
        linkedlistStack.show();




    }
}
//链表模拟栈
class LinkedlistStack{
    private Node head = new Node();
    private int maxSize;

    LinkedlistStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        return getLength() == maxSize;
    }

    public boolean isEmpty(){
        return head.next == null;
    }

    public void push(int num){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        Node node = new Node(num);
        Node temp = head.next;
        head.next = node;
        node.next = temp;
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node node = head.next;
        System.out.println(node.num);
        head.next = node.next;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        Node node = head.next;
        while (node != null){
            System.out.println(node.num);
            node = node.next;
        }
    }

    public int getLength(){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        Node cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}


class Node{
    public int num;
    public Node next;

    public Node() {
    }

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }
}

class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//模拟栈的数组
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){//入栈
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){

        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void list(){//遍历
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack["+i+"] :" + stack[i]);
        }

    }
}