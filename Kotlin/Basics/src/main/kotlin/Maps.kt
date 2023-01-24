

fun main(args: Array<String>) {
    val  aMap= mapOf(1 to "Parthib",3 to "Rohan",true to 3.6)
    println(aMap.get(1))
    println(aMap.get(20))
    println(aMap.get(3))
    println(aMap.get(true))
    println(aMap)


    val mMap= mutableMapOf(3 to "Rohan",true to 3.6)
    mMap.put(3.5,"Ronit")
    println(mMap)
    mMap[3]="Parthib"
    println(mMap)
}