package com.company;

public class roman {
    static int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++){

            if (s.charAt(i) =='M'){
                sum+=1000;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
                sum+=900;
                i++;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                sum+=400;
                i++;
                continue;
            }

            if (s.charAt(i) == 'D'){
                sum+=500;
                continue;
            }

            if (s.charAt(i) == 'C'){
                sum+=100;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
                sum+=40;
                i++;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
                sum+=90;
                i++;
                continue;
            }

            if (s.charAt(i) == 'L'){
                sum+=50;
                continue;
            }

            if (s.charAt(i) == 'X'){
                sum+=10;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
                sum+=9;
                i++;
                continue;
            }

            if (i+1 < len && s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                sum+=4;
                i++;
                continue;
            }

            if (s.charAt(i) == 'V'){
                sum+=5;
                continue;
            }

            if (s.charAt(i) == 'I'){
                sum+=1;
                continue;
            }
        }
        return sum;
    }

    static String intToRoman(int n,String s){
        if(n==1){
            return "I";
        }
        if(n==4){
            return "IV";
        }
        if(n==5){
            return "V";
        }
        if(n==10){
            return "X";
        }
        if(n==50){
            return "L";
        }
        if(n==100){
            return "C";
        }
        if(n==500){
            return "D";
        }
        if(n==1000){
            return "M";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
