package com.company;

public class Recurtion_skip {
    public static void main(String[] args) {
      skip_a("","baccad");
        System.out.println(skip_a2("baaccad"));
        System.out.println(skipapple("abscappledgfapphgappleffhf"));
        System.out.println(skipappnotapple("abscappledgfapphgappleffhf"));
    }
    static  void skip_a(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            skip_a(p,up.substring(1));
        }else{
            skip_a(p+ch,up.substring(1));
        }
    }
    static  String skip_a2(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch=='a'){
           return skip_a2(up.substring(1));
        }else{
            return ch+skip_a2(up.substring(1));
        }
    }
    static  String skipapple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(up.startsWith("apple")){
            return skipapple(up.substring(5));
        }else{
            return ch+skipapple(up.substring(1));
        }
    }
    static  String skipappnotapple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(up.startsWith("app") &&  !up.startsWith("apple")){
            return skipappnotapple(up.substring(5));
        }else{
            return ch+skipappnotapple(up.substring(1));
        }
    }
}
