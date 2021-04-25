//https://www.techiedelight.com/minimum-number-of-squares-that-sum-to-given-number/

package org.kotlinlang.play

import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val result = getComposition(89.toDouble())
}

fun getComposition(inpput: Double): List<Double> {
    var result = emptyList<Double>()
    if (inpput == 0.0) return result
    val sqRoot = sqrt(inpput.toDouble())
    val actualNum = Math.floor(sqRoot)
    result = result.plus(actualNum)
    val leftOver = inpput - actualNum.pow(2.0)
    result = result.plus(getComposition(leftOver))
    return result
}
