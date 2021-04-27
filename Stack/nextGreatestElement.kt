//https://www.techiedelight.com/next-greater-element/

package org.kotlinlang.play

import java.util.*

fun main(args: Array<String>) {
    val sut = intArrayOf(2, 7, 3, 5, 4, 6, 8)
    val result = getNextGreaterNumber(sut)
}

fun getNextGreaterNumber(sut: IntArray): IntArray {
    var _stack = Stack<Int>()
    _stack.push(999)
    val result = IntArray(sut.size)
    for (index in sut.size-1 downTo 0) {
        val value = sut[index]
        while (_stack.peek() < value) {
            _stack.pop()
        }
        result[index] = _stack.peek()
        _stack.push(value)
    }
    return result
}
