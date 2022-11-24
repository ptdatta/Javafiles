package com.company;

/**
 * This class is to demonstrate what javadoc is and how it works
 * This is <i>italic</i> word, <p>This is a paragraph</p>
 * @author Parthib(CodeWithParthib)
 * @version 0.1
 * @since 2002
 * @see <a href="https://docs.oracle.com/en/java/javase/14/docs/api/index.html">Java Docs</a>
 */


public class Main {

    /**
     * Hello this is a method and this is the most beautiful method of this class
     * @param i This is the first number to add
     * @param j This is the second number to add
     * @return Sum of two numbers as an integer
     * @throws Exception if i is 0
     * @deprecated This method is deprecated please use + Operator
     */

    public int add(int i, int j) throws Exception{
        if(i==0){
            throw new Exception();
        }
        int c;
        c= i+ j;
        return c;
    }

    /**
     *
     * @param args This is the main method
     */

    public static void main(String[] args) {
        System.out.println("This is my main method");
    }
}