package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

            //代码实现中缀表达式转换逆波兰表达式并计算   （可优化 看注释）
public class ReversePolishNotation {
    public static void main(String[] args) {

        // 4*5-8+60+8/2  =>  4 5 * 8 - 60 + 8 2 / +

        /*String notation = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getList(notation);
        System.out.println(list);
        int result = calculator(list);
        System.out.println(result);*/

        String revPolish = getRevPolish("1+((2+3)*4)-5");//   1+((2+3)*4)-5 =>  1 2 3 + 4 * + 5 -
        System.out.println(revPolish);
        List<String> list = getList(revPolish);
        int result = calculator(list);
        System.out.println(result);


    }

    public static List<String> getList(String notation){
        String[] split = notation.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculator(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //正则表达式
            if (s.matches("\\d+")){//正则表达式，，多位数
                stack.push(s);
            }else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int result = 0;
                if (s.equals("+")){
                    result = a + b;
                }else if (s.equals("-")){
                    result = b - a;
                }else if (s.equals("*")){
                    result = b * a;
                }else {
                    result = b / a;
                }
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //中缀转后缀表达式
    //  1+((2+3)*4)-5 =>  1 2 3 + 4 * + 5 -
    public static String getRevPolish(String not){
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
        //此时已经得到中缀表达式的list

        //接下来转后缀
        Stack<String> stack1 = new Stack<>();//存放运算符
        Stack<String> stack2 = new Stack<>();//存放中间结果   优化 直接用list

        for (int j = 0; j < list.size(); j++) {  //优化 用增强for
            if (list.get(j).matches("\\d+")){
                stack2.push(list.get(j));  //数字直接压栈2
            }else{
                if (list.get(j).equals("(") || stack1.size() == 0 || stack1.lastElement().equals("(")){
                    stack1.push(list.get(j));
                }else if (list.get(j).equals(")")){
                    String s;
                    while (!(s = stack1.pop()).equals("(")){
                        stack2.push(s);
                    }
                }else {
                    while (stack1.size() != 0 && !stack1.lastElement().equals("(") && priority(list.get(j)) <= priority(stack1.lastElement())){
                        stack2.push(stack1.pop());
                    }
                    stack1.push(list.get(j));
                }
            }
        }

        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }

        Stack<String> stack = new Stack<>();

        while (stack2.size() != 0){
            stack.push(stack2.pop());
        }
        //优化  直接转list 不是String

        String s = "";
        while (stack.size() != 0){
            s += stack.pop();
            s += " ";
        }

        return s;
    }

    public static int priority(String s){
        if (s.equals("*") || s.equals("/")){
            return 2;
        }else {
            return 1; // + -
        }
    }
}
