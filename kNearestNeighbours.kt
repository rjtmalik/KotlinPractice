//https://www.techiedelight.com/find-k-closest-elements-to-given-value-array/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val sut = intArrayOf(10, 12, 15, 17, 18, 20, 25)
    val output = kNearestNeighbours(sut, 4, 16)
    println(output.map { x -> x })
}

fun kNearestNeighbours(sut: IntArray, k: Int, x: Int): IntArray {
    var low = 0
    var high = sut.size
    while (1 < high - low) {
        val searchIndex = (low + high) / 2
        if (sut[searchIndex] < x)
            low = searchIndex
        else if (sut[searchIndex] > high)
            high = searchIndex
        else {
            low = searchIndex
            high = searchIndex
        }
    }
    var i = 0
    //if element found
    if (high == low) {
        i = 1
    }
    var selections = 0;
    var result = mutableListOf<Int>()
    while (selections < k) {
        if (low - i > -1) {
            result.add(sut[low - i])
            selections++
        }
        if (high + i < sut.size) {
            result.add(sut[high + i])
            selections++
        }
        i++
    }
    return result.toIntArray()
}
