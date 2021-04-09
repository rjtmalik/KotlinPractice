//https://www.techiedelight.com/find-smallest-missing-positive-number-unsorted-array/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val sut = arrayOf(1, 4, 2, -1, 6, 5)
    val root = bstFrom(sut)
    missingSmallestPositiveNumber(root)
}

class Node(val Value: Int, var Left: Node?, var Right: Node?)

var sortedList = mutableListOf<Int>()

fun missingSmallestPositiveNumber(root: Node?) {
    if (root == null) return
    missingSmallestPositiveNumber(root.Left)
    if(sortedList.isNotEmpty() && root.Value - sortedList.last() > 1){
        println(sortedList.last() + 1)
        return
    }
    sortedList.add(root.Value)
    missingSmallestPositiveNumber(root.Right)
}

fun bstFrom(unsortedArray: Array<Int>): Node {
    val root = Node(Value = unsortedArray[0], Left = null, Right = null)
    for (e in unsortedArray.drop(1)) {
        if (e > 0) {
            addToTree(root, e)
        }
    }
    return root
}

fun addToTree(root: Node, element: Int) {
    if (root.Value < element) {
        if (root.Right == null) {
            root.Right = Node(element, null, null)
        } else {
            addToTree(root.Right!!, element)
        }
    } else {
        if (root.Left == null) {
            root.Left = Node(element, null, null)
        } else {
            addToTree(root.Left!!, element)
        }
    }
}
