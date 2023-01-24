package com.company;

public class Pattern {
    public static void main(String[] args) {
        p_7(4);
    }
    static void p_1(int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return;
    }
    static void p_2(int n){
        for(int i=1;i<=n;i++){
            for (int j=n-i+1;j>=1;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        return;
    }
    static void p_3(int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return;
    }
    static void p_4(int n) {
        for (int i = 1; i <=n ; i++) {
            for (int j = n-i; j >=1 ; j--) {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n-1; i >=1 ; i--) {
            for (int j = n-i; j >=1 ; j--) {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void p_5(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j >=1 ; j--) {
                System.out.print("  ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void p_6(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n-i; j >=1 ; j--) {
                System.out.print("  ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        for (int i = n-1; i >=1; i--) {
            for (int j = n-i; j >=1 ; j--) {
                System.out.print("  ");
            }
            for (int j = i; j >=1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <=i ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void p_7(int n){
        int m=2*n-1;
        for (int i = 1; i <= n ; i++) {
            for (int j = n; j >=n-i+1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = m-(2*i)+2; j >1 ; j--) {
                System.out.print(n-i+1+" ");
            }
            for (int j = n-i+2; j<=n ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        for (int i = n-1; i >=1 ; i--) {
            for (int j = n; j >=n-i+1 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = m-(2*i)+2; j >1 ; j--) {
                System.out.print(n-i+1+" ");
            }
            for (int j = n-i+2; j<=n ; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
