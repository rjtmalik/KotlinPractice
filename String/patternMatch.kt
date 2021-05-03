//https://www.techiedelight.com/determine-string-follows-specified-order/

package org.kotlinlang.play

import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val sut = "Techie Delight"
    val pattern = "ch"
    val result = isPatternMatched(sut, pattern)
}

fun isPatternMatched(sut: String, pattern: String): Boolean {
    val map = HashMap<Char, List<Int>>()
    for ((index, value) in sut.withIndex()) {
        if (map.containsKey(value)) {
            map[value] = map[value]?.plus(index)!!
        } else {
            map[value] = listOf(index)
        }
    }
    var i = 1
    while (i < pattern.length) {
        val higher = pattern[i]
        var lower = pattern[i - 1]

        var lowestIndexOfHigher = map[higher]?.first()!!
        var highestIndexOfLower = map[lower]?.last()!!
        if (lowestIndexOfHigher < highestIndexOfLower) return false
        i++
    }
    return true
}
