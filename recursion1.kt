//https://www.techiedelight.com/truncate-array-such-that-twice-of-min-becomes-more-than-max/

package org.kotlinlang.play

var _memo = mutableMapOf<List<Int>, List<Int>>()

fun main(args: Array<String>) {
    val sut = listOf<Int>(4, 6, 1, 7, 5, 9, 2)
    println(truncatedArr(sut))
}

fun truncatedArr(sut: List<Int>): List<Int> {

    if (_memo.containsKey(sut)) {
        return _memo[sut]!!
    }

    val min = sut.minOf { x -> x }
    val max = sut.maxOf { x -> x }

    if (min * 2 > max) {
        return sut
    }

    val case1 = truncatedArr(sut.drop(1))
    val case2 = truncatedArr(sut.dropLast(1))
    var result = listOf<Int>()
    result = if (case1.size > case2.size) {
        case1
    } else {
        case2
    }
    _memo[sut] = result
    return result
}
