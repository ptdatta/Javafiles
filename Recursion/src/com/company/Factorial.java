package com.company;

public class Factorial {

    static String factorial(int n){
        if(n<2){
            return "1";
        }
        String s=Integer.toString(n);
        return  multiply(s,factorial(n-1));
    }
    static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int first = 0, second = 0, carry = 0, sum = 0;
        int[] result = new int[n1 + n2];

        for(int i = n1 - 1; i>= 0; i--){
            second = 0;
            carry = 0;
            int no1 = num1.charAt(i) - '0';

            for(int j = n2 - 1; j >= 0; j--){
                int no2 = num2.charAt(j) - '0';

                sum = no1 * no2 + result[first + second] + carry;
                carry = sum / 10;
                result[first + second] = sum % 10;
                second++;
            }

            if(carry > 0){
                result[first + second] += carry;
            }
            first++;
        }

        int i=n1+n2-1;
        while(i>0&&result[i]==0)
            i--;

        String str = "";
        while(i >= 0){
            str+=result[i];
            i--;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5558));
    }
}
