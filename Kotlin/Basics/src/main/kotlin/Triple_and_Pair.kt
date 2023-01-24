fun main(args: Array<String>) {
    val (a,b)=Pair("A",1)
    println(message = "$a $b")
    val name=Pair(1.3,Pair(2,true))
    println("${name.first} & ${name.second} & ${name.second.first}")

    val (x,y,z)=Triple(2,true,3.6)
    println("$x $y $z")
}