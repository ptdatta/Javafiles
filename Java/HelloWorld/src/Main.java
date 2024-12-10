public class Main {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        s.replace(1,4,"op");
        s.append('l');
        System.out.println(s.subSequence(2,4));
        System.out.println(s.toString().length());
        System.out.println(s);
//        System.out.println(s.reverse().toString());
    }
}