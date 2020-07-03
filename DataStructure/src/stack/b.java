package stack;

import java.util.Stack;

public class b {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("(");
        String q = "(";
        boolean w =  stack.lastElement() == "(";
        System.out.println(w);
    }
}
