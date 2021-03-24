//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/love-or-life/

package org.kotlinlang.play

fun main(args: Array<String>) {
    readLine()
    val numbers = readLine()!!.split(" ").map { x -> x.toInt() }.toIntArray()
    val searchOutput = subArrayPossibilityFor(numbers)
    if (searchOutput) {
        println("YES")
    } else {
        println("NO")
    }
}

fun subArrayPossibilityFor(numbers: IntArray): Boolean {
    var first = numbers.take(numbers.size / 2)
    var second = numbers.drop(first.size)
    return getResult(first, second)
}

fun getResult(first: List<Int>, second: List<Int>): Boolean{
    var firstSum = first.sum()
    var secondSum = second.sum()
    val searchNum = Math.abs(secondSum - firstSum)
    if (secondSum > firstSum) {
        var isFound = second.any { x -> x == searchNum }
        if(isFound) return isFound
        if(second.size ==1) return false
        var firstNew = first.plus(second.first())
        var secondNew = second.take(0)
        return getResult(firstNew, secondNew)
    }
    else if(firstSum> secondSum){
        var isFound = first.any { x -> x == searchNum }
        if(isFound) return isFound
        if(first.size ==1) return false
        var secondNew = second.plus(first.last())
        var firstNew = first.take(first.size - 1)
        return getResult(firstNew, secondNew)
    }
    else{
        return false
    }
}
