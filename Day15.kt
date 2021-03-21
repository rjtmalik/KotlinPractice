//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/find-the-odd/

package org.kotlinlang.play

fun main(args: Array<String>){
    val countOfNum = readLine()!!.toInt()
    val numbers = readLine()
    println(missingOddNumberIn(numbers!!, countOfNum))
}

fun missingOddNumberIn(numbersStr: String, countOfNum: Int): Int{
    val sum = (countOfNum) *(countOfNum)
    if(numbersStr.isEmpty()){
        return sum
    }
    val numbers = numbersStr.split(" ").map{x-> x.toInt()}.toIntArray()
    val actualSum = numbers.sum()
    return sum - actualSum
}
