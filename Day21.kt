//https://www.techiedelight.com/find-maximum-value-index-array/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val arr = intArrayOf(9, 10, 2, 6, 7, 12, 8, 1)
    print(maxValue(arr))
}

fun maxValue(numbers: IntArray): Int {
    var result = Int.MIN_VALUE
    (numbers.indices).forEach { i ->
        (numbers.indices).forEach {j->
            val sum = numbers[j] - numbers[i]
            if (sum > 0) {
                val max = j - i
                result = Math.max(max, result)
            }
        }
    }
    return result
}
