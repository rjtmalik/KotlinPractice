//https://www.techiedelight.com/fix-children-sum-property-binary-tree/

package org.kotlinlang.play

class Node(var Left: Node?, var Right: Node?, var Value: Int)

fun main(args: Array<String>) {
    val n4 = Node(null, null, 4)
    val n7 = Node(null, null, 7)
    val n8 = Node(null, null, 8)
    val n5 = Node(n7, n8, 5)
    val n6 = Node(null, null, 6)
    val n3 = Node(n5, n6, 3)
    val n2 = Node(n4, null, 2)
    val n1 = Node(n2, n3, 1)

    val result = childrenSumBT(n1)
    println(n1)
}

fun childrenSumBT(root: Node?) {
    if (root == null) {
        return;
    }
    val diff = root.Value - nodeValue(root.Left) - nodeValue(root.Right)
    if (diff > 0) {
        if (root.Left == null && root.Right != null) {
            root.Right!!.Value += diff
        } else if (root.Right == null && root.Left != null) {
            root.Left!!.Value += diff
        }
    }

    childrenSumBT(root.Left)
    childrenSumBT(root.Right)

    val temp = nodeValue(root.Left) + nodeValue(root.Right)
    if(temp > 0)
        root.Value = temp
}

fun nodeValue(element: Node?): Int {
    if (element == null)
        return 0
    return element.Value
}
