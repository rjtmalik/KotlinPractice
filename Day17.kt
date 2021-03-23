//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/tired-of-trying/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val countCases = readLine()!!.toInt()
    var result = mutableListOf<Int>()
    for (e in 0 until countCases) {
        readLine()
        val numbers = readLine()!!.split(" ").map { x -> x.toInt() }.toIntArray()
        result.add(minimumFor(numbers))
    }
    result.map { x-> println(x) }
}

fun minimumFor(numbers: IntArray): Int {
    var result = Int.MAX_VALUE
    var grandSum = numbers.sum()
    for (e in 0 until numbers.size - 1) {
        result = Math.min(result, minimumForStartIndex(numbers, e, grandSum))
        grandSum -= numbers[e]
    }
    return result
}

fun minimumForStartIndex(numbers: IntArray, startIndex: Int, grandSum: Int): Int {
    var endIndex = numbers.size - 1
    var result = grandSum
    var movingSum = grandSum
    while (endIndex > startIndex) {
        result = Math.min(result, movingSum - (endIndex - startIndex + 1))
        movingSum -= numbers[endIndex]
        endIndex--
    }
    return result
}
