package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Arithmatic {
    static int Prec(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp)
    {
        String result = new String("");

        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }

                stack.pop();
            }
            else
            {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {

                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }

        return result;
    }

    static int evaluatePostfix(String exp)
    {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);

            if(Character.isDigit(c))
                stack.push(c - '0');

            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow((double) val2,(double) val1));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args)
    {
        String exp = "1+2*(3^4-5)^(2+1*8)-5";
        System.out.println(evaluatePostfix(infixToPostfix(exp)));
    }
}
