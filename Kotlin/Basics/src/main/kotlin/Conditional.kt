fun main(args: Array<String>) {
    var num=11
    if(num>56){
        println("Greater than 56")
    }else if(num<0){
        println("Negative")
    }else{
        println("Num is 11")
    }

    when{
        num>56 ->{
            println("Greater than 56")
        }
        num<0->{
            println("Negative")
        }
        num==11->{
            println("Num is 11")
        }
        else->{
            println("God knows")
        }
    }
    when(num){
        1->{
            println("Num is 1")
        }
        10->{
            println("Num is 11")
        }
        else->{
            println("God knows")
        }
    }
}