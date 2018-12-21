package com.zfg.test.javatest;

import java.util.Stack;

/**
 * Created by zfg on 2018/12/17
 * 栈
 */
public class StackTest {
    public static void main(String[] strings) {
        String[] sorces = new String[]{"5","-2","4","C","D","9","+","+"};
        int count = countStack(sorces);
        System.out.println("总分数：" + count);
    }

    private static int countStack(String[] ops) {
        int count = 0;
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    integers.pop();
                    break;
                case "D":
                    integers.push(integers.peek() * 2);
                    break;
                case "+":
                    int top = integers.pop();
                    int newtop = top + integers.peek();
                    integers.push(top);
                    integers.push(newtop);
                    break;
                default:
                    integers.push(Integer.parseInt(ops[i]));
                    break;
            }
        }
        for (int score : integers)
            count += score;
        return count;
    }
}
