//https://www.techiedelight.com/find-missing-term-sequence-ologn-time/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val sequence = intArrayOf(5, 9, 11, 13, 15, 17)
    val result = missingNumberIn(sequence)
    println(result)
}

fun missingNumberIn(sequence: IntArray): Int {
    var low = 0
    var high = sequence.size - 1

    var leftOptionByDivision = 0
    var rightOptionByDivision = 0

    var rightOptionRemainder = 0

    while (1 < (high - low)) {
        var mid = (low + high) / 2
        leftOptionByDivision = (sequence[mid] - sequence[low]) / (mid - low)
        rightOptionByDivision = (sequence[high] - sequence[mid]) / (high - mid)
        rightOptionRemainder = (sequence[high] - sequence[mid]) % (high - mid)
        if (rightOptionByDivision > leftOptionByDivision || rightOptionRemainder > 0) {
            low = mid
        } else {
            high = mid
        }
    }

    return (sequence[low] + (sequence[high] - sequence[low]) / 2)
}

