//https://www.techiedelight.com/construct-binary-tree-from-inorder-level-order-traversals/

package org.kotlinlang.play

class Node(var Left: Node?, var Right: Node?, var Value: Int)

fun main(args: Array<String>) {
    val inOrder = intArrayOf(4, 2, 5, 1, 6, 3, 7)
    val levelOrder = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val root = Node(null, null, levelOrder[0])
    createNode(root, inOrder, levelOrder)
}

fun createNode(root: Node, inOrder: IntArray, levelOrder: IntArray) {
    var rootIndex = inOrder.indexOf(root.Value)
    var leftSubArray = inOrder.filterIndexed { index, i -> index < rootIndex }.toIntArray()
    var rightSubArray = inOrder.filterIndexed { index, i -> index > rootIndex }.toIntArray()
    val leftRoot = getRoot(leftSubArray, levelOrder)
    val rightRoot = getRoot(rightSubArray, levelOrder)
    root.Left = leftRoot
    root.Right = rightRoot
    createNode(leftRoot, leftSubArray, levelOrder)
    createNode(rightRoot, leftSubArray, levelOrder)
}

fun getRoot(inOrder: IntArray, levelOrder: IntArray): Node {
    var minIndex = Int.MAX_VALUE
    for (e in inOrder) {
        var lvlIndex = levelOrder.indexOf(e)
        if (lvlIndex < minIndex) {
            minIndex = lvlIndex
        }
    }
    return Node(null, null, levelOrder.elementAt(minIndex))
}
