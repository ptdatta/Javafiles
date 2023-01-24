fun main(args: Array<String>) {

//    For Loop
    for(i in 3..10){
        println(i)
    }
    for(i in 0 until 10 step 3){
        println(i)
    }
    for (i in 10 downTo 0 step 2){
        println(i)
    }


//    While Loop
    var num=10;
    while (num<20){
        println(num)
        num++
    }


//    Do while Loop
    do{
        println(num)
        num++;
    }while (num<30)
}