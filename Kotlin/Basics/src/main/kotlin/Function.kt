// Any means you can return any type of variable's
fun add(a : Int, b: Int) : Any {
    return a+b;
}

fun add(a : Int, b: Int,c: Int) : Int {
    return a+b+c;
}

fun main(args: Array<String>) {
   println("The sum is ${add(7,5,2)}")
}