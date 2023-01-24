

fun main(args: Array<String>) {
    val aSet= setOf<Any>("hello",12,3.6)
    println(aSet)

    val mSet= mutableSetOf<Any>(12,0)
    mSet.add(false)
    println(mSet)
}