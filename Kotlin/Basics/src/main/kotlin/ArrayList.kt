fun main(args: Array<String>) {
    val arr=ArrayList<Any>()
    arr.add(0)
    arr.add("Parthib")
    arr.add(3.6)
    arr.add(true)
    println(arr.get(2))
    println(arr.size)
    println(arr)
    arr.removeAt(1)
    arr.remove(3.6)
    println(arr)
}