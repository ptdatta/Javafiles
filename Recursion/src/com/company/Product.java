package com.company;

public class Product {
    static int product(int x, int y)
    {
        // if x is less than
        // y swap the numbers
        if (x < y)
            return product(y, x);

            // iteratively calculate
            // y times sum of x
        else if (y != 0)
            return (x + product(x, y - 1));

            // if any of the two numbers is
            // zero return zero
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(product(5,2));
    }
}
