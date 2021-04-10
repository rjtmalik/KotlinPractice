//https://www.techiedelight.com/find-minimum-depth-binary-tree/

package org.kotlinlang.play
import java.util.*

fun main(args: Array<String>) {
    val n12 = Node(12, null, null)
    val n8 = Node(8, n12, null)
    val n9 = Node(9, null, null)
    val n10 = Node(10, null, null)
    val n11 = Node(11, null, null)
    val n4 = Node(4, null, n8)
    val n5 = Node(5, null, n9)
    val n6 = Node(6, null, null)
    val n7 = Node(7, n10, n11)
    val n2 = Node(2, n4, n5)
    val n3 = Node(3, n6, n7)
    val n1 = Node(1, n2, n3)

    println(minDepthToLeaftFrom(n1))

}

class Node(val Value: Int, var Left: Node?, var Right: Node?)
class QueueElement(val Element: Node, val Height: Int)

fun minDepthToLeaftFrom(root: Node): Int {
    var levelOrderQueue: Queue<QueueElement> = LinkedList<QueueElement>()
    levelOrderQueue.add(QueueElement(root,1))
    while (levelOrderQueue.isNotEmpty()) {
        val dequeuedNode = levelOrderQueue.remove()
        if (dequeuedNode.Element.Left == null && dequeuedNode.Element.Right == null) return dequeuedNode.Height
        if (dequeuedNode.Element.Left != null) levelOrderQueue.add(QueueElement(dequeuedNode.Element.Left!!, dequeuedNode.Height+1))
        if (dequeuedNode.Element.Right != null) levelOrderQueue.add(QueueElement(dequeuedNode.Element.Right!!, dequeuedNode.Height+1))
    }
    return  0
}
