//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/micro-and-array-update/

fun main(args: Array<String>) {
    val testCases = readLine()!!.toInt()
    val result = IntArray(testCases)
    for (i in result.indices) {
        val k = readLine()!!.split(" ")[1].toInt()
        val sut = readLine()!!.split(" ").map { x-> x.toInt() }
        result[i] = secondsToReach(k, sut.toIntArray())
    }
    result.map { x-> println(x) }
}

fun secondsToReach(target: Int, sut: IntArray): Int{
    val min = sut.minOf { x-> x }
    if(target <= min){
        return 0
    }
    if(min < 0){
        return target + Math.abs(min)
    }
    return target - min
}
