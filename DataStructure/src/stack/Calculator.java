package stack;

public class Calculator {
    public static void main(String[] args) {
        String expression ="93-2*2+4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        char[] chars = expression.toCharArray();
        try {
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
//                System.out.println(ch);
                calculator(operStack, numStack, ch);
                if (i == chars.length - 1) {
                    int num1 = 0;
                    int num2 = 0;
                    int oper = 0;
                    int result =  0;
                    while (!operStack.isEmpty()) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = numStack.cal(num1, num2, oper);
                        numStack.push(result);
                    }
                    System.out.println(result);
                }
            }
        }catch (Exception e){

        }
    }

    public static void calculator(ArrayStack2 operStack,ArrayStack2 numStack,char ch){
        if (operStack.isOper(ch)){
            if (operStack.isEmpty()){
                operStack.push(ch);
                numStack.index--;
            }else {
                if (operStack.priority(ch) <= operStack.priority(operStack.looktop())){
                    int num1 =numStack.pop();
                    int num2 =numStack.pop();
                    int oper = operStack.pop();
                    int result = numStack.cal(num1,num2,oper);
                    numStack.push(result);
                    calculator(operStack,numStack,ch);
                }else{
                    operStack.push(ch);
                    numStack.index--;

                }
            }
        } else{
            if (numStack.index == 1){
                int pop = numStack.pop();
                int number = pop*10 + Integer.parseInt(ch + "");
                numStack.push(number);
            }else {
                numStack.push(Integer.parseInt(ch + ""));
                numStack.index++;

            }
        }


    }
}


class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//模拟栈的数组
    private int top = -1;//栈顶
    public int index = 0;

    public ArrayStack2(int maxSize) {
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

    public int looktop(){
        return stack[top];
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

    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 2;
        }else {
            return 1; // + -
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '/' || val == '*' ;
    }

    public int cal(int num1 ,int num2, int oper){
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;///注意顺序
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;//注意顺序
                break;
        }
        return result;
    }
}