package stack;

import java.util.ArrayList;
import java.util.Stack;

public class a {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.lastElement());//栈顶
        System.out.println(stack.pop());
        System.out.println(stack.lastElement());//栈顶
        System.out.println("3" != "3");

//        int a;
//        while ((a=stack.pop())!=1){
//            System.out.println(a);
//        }
        String not = "1+((2+3)*4)-5";
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        while (i < not.length()){
            c = not.charAt(i);
            if (c < 48 || c >57) {//非数字
                list.add(c + "");
                i++;
            }else {
                str = "";
                while (i < not.length() && (c = not.charAt(i)) >= 48 && (c = not.charAt(i)) <=57){ //判断多位数
                    str += c; //拼接字符串
                    i++;
                }
                list.add(str);
            }
        }
        System.out.println(list);


        Stack<String> stack1 = new Stack<>();//存放运算符
//        System.out.println(stack1.size() == 0);
        Stack<String> stack2 = new Stack<>();//存放中间结果

        /*System.out.println(list.get(0));
        System.out.println(list.get(0).matches("\\d+"));*/



       //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).matches("\\d+")){
                stack2.push(list.get(j));
            }else{
                if (list.get(j).equals("(") || stack1.size() == 0 || stack1.lastElement().equals("(")){
                    stack1.push(list.get(j));
                }else if (list.get(j).equals(")")){
                    String s;
                    while (!(s = stack1.pop()).equals("(")){
                        stack2.push(s);
                    }
                }else {
                    while (stack1.size() != 0 && !stack1.lastElement().equals("(") &&  priority(list.get(j)) <= priority(stack1.lastElement())){
                        stack2.push(stack1.pop());
                    }
                    stack1.push(list.get(j));
                }
            }
        }

        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }


        while (stack2.size() != 0){
            System.out.println(stack2.pop());   //     1 2 3 + 4 * + 5 - 的相反
        }

    }
    public static int priority(String s){
        if (s.equals("*") || s.equals("/")){
            return 2;
        }else {
            return 1; // + -
        }
    }
}
