//https://www.techiedelight.com/previous-smaller-element/

package org.kotlinlang.play

import java.util.*


fun main(args: Array<String>) {
    val sut = intArrayOf(2, 5, 3, 7, 8, 1, 9)
    previousSmallerArrOf(sut).map { x-> println(x) }
}

fun previousSmallerArrOf(sut: IntArray): IntArray {
    val result = IntArray(sut.size)
    var parsedElementsStack = Stack<Int>()
    for ((index, e) in sut.withIndex()) {
        while (parsedElementsStack.isNotEmpty()) {
            if (parsedElementsStack.peek() < e) {
                result[index] = parsedElementsStack.peek()
                break
            }
            parsedElementsStack.pop()
        }
        if (parsedElementsStack.isEmpty()) {
            result[index] = -1
        }
        parsedElementsStack.push(e)
    }
    return result
}

