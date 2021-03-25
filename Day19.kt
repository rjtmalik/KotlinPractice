//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/the-code-generator-9d3f9afa/

package org.kotlinlang.play

fun main(arg: Array<String>) {
    val testCases = readLine()!!.toInt()
    var result = arrayOfNulls<String>(testCases)
    var _map = mutableMapOf<Int, String>()
    for (e in 0 until testCases) {
        val num = readLine()!!.toInt()
        result[e] = binaryNum(num, _map)
    }
    result.map { x-> println(x) }
}

fun binaryNum(number: Int, _map :MutableMap<Int, String>): String {
    if(_map.containsKey(number)) {
        return _map[number]!!
    }
    var current = 1
    var counter = 1
    var result = ""
    while (counter <= number) {
        var binaryString = Integer.toBinaryString(current)
        if (!binaryString.contains("11")) {
            result = binaryString
            _map[counter] = result
            counter++
        }
        current++
    }
    return result
}
