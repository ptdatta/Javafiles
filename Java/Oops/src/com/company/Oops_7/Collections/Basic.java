package com.company.Oops_7.Collections;

public class Basic  {

    enum Week implements A{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;     //type is week
        ;

        Week() {
            System.out.println("Constructor called for "+this);
        }

        @Override
           public void hello() {
                 System.out.println("hey how are you?");
           }
    }

    public static void main(String[] args) {
        Week week;
        week=Week.Friday;
        week.hello();
        System.out.println(Week.valueOf("Monday"));
//        for(Week day: Week.values() ){
//            System.out.println(day);
//        }
//        System.out.println(week.ordinal());
    }
}
