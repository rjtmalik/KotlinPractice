//https://www.techiedelight.com/remove-loop-linked-list/

import kotlin.collections.HashSet

class Node(var Next: Node?, val Value: Int)

fun main(arg: Array<String>) {
    //create a cyclic list
    val n5 = Node(null, 5)
    val n4 = Node(n5, 4)
    val n3 = Node(n4, 3)
    val n2 = Node(n3, 2)
    val n1 = Node(n2, 1)
    //n5.Next = n2
    println(hasCycle(n1))
}

fun hasCycle(root: Node): Boolean {
    val memo = HashSet<Node>()
    var recursiveNode: Node? = root
    while (recursiveNode != null) {
        if (memo.contains(recursiveNode)) {
            return true
        } else {
            memo.add(recursiveNode)
            recursiveNode = recursiveNode.Next
        }
    }
    return false
}

