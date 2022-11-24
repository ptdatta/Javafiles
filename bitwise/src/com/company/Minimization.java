package com.company;

import java.util.*;

public class Minimization {
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

        // The main method that converts
        // given infix expression
        // to postfix expression.
        static String infixToPostfix(String exp)
        {
            // initializing empty String for result
            String result = new String("");

            // initializing empty stack
            Deque<Character> stack
                    = new ArrayDeque<Character>();

            for (int i = 0; i < exp.length(); ++i) {
                char c = exp.charAt(i);

                // If the scanned character is an
                // operand, add it to output.
                if (Character.isLetterOrDigit(c))
                    result += c;

                    // If the scanned character is an '(',
                    // push it to the stack.
                else if (c == '(')
                    stack.push(c);

                    //  If the scanned character is an ')',
                    // pop and output from the stack
                    // until an '(' is encountered.
                else if (c == ')') {
                    while (!stack.isEmpty()
                            && stack.peek() != '(') {
                        result += stack.peek();
                        stack.pop();
                    }

                    stack.pop();
                }
                else // an operator is encountered
                {
                    while (!stack.isEmpty()
                            && Prec(c) <= Prec(stack.peek())) {

                        result += stack.peek();
                        stack.pop();
                    }
                    stack.push(c);
                }
            }

            // pop all the operators from the stack
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                result += stack.peek();
                stack.pop();
            }

            return result;
        }
        static  List<List<String>> groupAnagrams(String[] s) {
            if (s.length == 1) {
                List<String> list = new ArrayList<>(1);
                list.add(s[0]);
                List<List<String>> res = new ArrayList<>(1);
                res.add(list);
                return res;
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String word : s) {
                char[] alphabet = new char[26];
                for (char c : word.toCharArray()) {
                    alphabet[c - 'a']++;
                }
                String key = new String(alphabet);
                if (map.containsKey(key)) {
                    map.get(key).add(word);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(key,list);
                }
            }
            return new ArrayList<>(map.values());
        }

        public static void main(String[] args) {
            String[] arr={"3","30","34","5","9"};
//            System.out.println(groupAnagrams(arr));
            Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
            System.out.println(Arrays.toString(arr));

        }

}
