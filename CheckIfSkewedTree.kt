//https://www.techiedelight.com/check-skewed-binary-tree/

package org.kotlinlang.play

class Node(var Left: Node?, var Right: Node?, var Value: Int)

fun main(args: Array<String>) {
    val n20 = Node(null, null, 20)
    val n18 = Node(null, n20, 18)
    val n25 = Node(n18, null, 25)
    val n30 = Node(n25, null, 30)
    val n15 = Node(null, n30, 30)

    println(isSkewed(n15))
}

fun isSkewed(root: Node?): Boolean {
    if (root == null) return true
    if (root.Left == null && root.Right != null) return isSkewed(root.Right)
    if (root.Left != null && root.Right == null) return isSkewed(root.Left)
    return true
}
