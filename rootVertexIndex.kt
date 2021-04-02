//https://www.techiedelight.com/root-vertex-graph/

package org.kotlinlang.play

class Node(var Next: List<Node>, var Value: Int)

fun main(args: Array<String>) {
    val n3 = Node(emptyList(), 3)
    val n2 = Node(listOf(n3), 2)
    val n1 = Node(listOf(n2), 1)
    val n0 = Node(listOf(n1), 0)
    val n5 = Node(listOf(n0), 5)
    val n4 = Node(listOf(n5, n3), 4)
    n3.Next = listOf(n0)

    println(rootIndex(listOf(n0, n1, n2, n3, n4, n5))?.Value)
}

fun rootIndex(candidates: List<Node>): Node? {
    val targetSize = candidates.size
    for (candidate in candidates) {
        val candidatePath = path(candidate)
        if (candidatePath.size == targetSize) return candidate
    }
    return null
}

fun path(candidate: Node): List<Node> {
    return traverseFrom(candidate, setOf(candidate))
}

fun traverseFrom(root: Node, visited: Set<Node>): List<Node> {
    var result = mutableListOf<List<Node>>()
    for (item in root.Next) {
        if (!visited.contains(item)) {
            val newSet = visited.plus(item)
            result.add(traverseFrom(item, newSet))
        }
    }
    var maxLengthList = listOf(root)
    for (item in result) {
        val updatedItem = item.plus(root)
        if (updatedItem.size > maxLengthList.size) {
            maxLengthList = updatedItem
        }
    }
    return maxLengthList
}
