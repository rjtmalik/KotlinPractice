//https://www.techiedelight.com/print-complete-binary-search-tree-increasing-order/

package org.kotlinlang.play

import java.util.*

fun main(args: Array<String>) {
    val levelOrderTraversal = intArrayOf(15, 10, 20, 8, 12, 18, 25)
    println(inorderTraversalOf(levelOrderTraversal))
}

fun inorderTraversalOf(sut: IntArray): List<Int> {
    var result = mutableListOf<Int>()
    var root = 0
    val elementStack = Stack<Int>()
    elementStack.push(root)
    while (elementStack.size > 0) {
        while (root == elementStack.peek() && root * 2 + 1 < sut.size) {
            root = root * 2 + 1
            elementStack.push(root)
        }
        root = elementStack.pop()
        result.add(sut[root])
        if (root * 2 + 2 < sut.size) {
            root = root * 2 + 2
            elementStack.push(root)
        }
    }
    return  result
}
