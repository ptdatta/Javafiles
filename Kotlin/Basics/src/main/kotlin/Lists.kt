

fun main(args: Array<String>) {
    val aList= listOf<Any>("Ramen", listOf(1,true,3.87),"Ramiz",true,1,"Parthib",2.0,3,"Rohan")
    println(aList)

    val mList= mutableListOf("Romit",23)
    println(mList)
    mList.add(true)
    mList.add(1,6.9)
    println(mList)
    mList.removeAt(1)
    println(mList)
    println(mList.size)
}