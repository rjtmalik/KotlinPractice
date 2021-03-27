//https://www.techiedelight.com/maximum-independent-set-problem/

package org.kotlinlang.play

class Node(var Left: Node?, var Right: Node?, var Value: Int)

val memo = mutableMapOf<Node, List<Int>>()

fun main(args: Array<String>) {
    val n4 = Node(null, null, 4)
    val n7 = Node(null, null, 7)
    val n8 = Node(null, null, 8)
    val n5 = Node(n7, n8, 5)
    val n6 = Node(null, null, 6)
    val n3 = Node(n5, n6, 3)
    val n2 = Node(n4, null, 2)
    val n1 = Node(n2, n3, 1)

    val result = mis(n1)
    result.map { x -> println(x) }
}

fun mis(root: Node?): List<Int> {
    if (root == null) {
        return emptyList<Int>()
    }
    if(memo.containsKey(root)){
        return memo[root]!!
    }
    //include
    var option1 = mutableListOf<Int>()
    var lleftGrandChild = root?.Left?.Left
    var lrightGrandChild = root?.Left?.Right
    var rleftGrandChild = root?.Right?.Left
    var rrightGrandChild = root?.Right?.Right
    option1.addAll(mis(lleftGrandChild))
    option1.addAll(mis(lrightGrandChild))
    option1.addAll(mis(rleftGrandChild))
    option1.addAll(mis(rrightGrandChild))
    option1.add(root.Value)

    //exclude
    var option2 = mutableListOf<Int>()
    val misLeft2 = mis(root?.Left)
    val misRight2 = mis(root?.Right)
    option2.addAll(misLeft2)
    option2.addAll(misRight2)
    if (option1.size > option2.size) {
        memo[root] = option1
        return option1
    } else {
        memo[root] = option2
        return option2
    }
}
