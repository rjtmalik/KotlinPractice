package org.kotlinlang.play

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/

fun main(args: Array<String>){
    val k = readLine()!!.toInt()
    var result = IntArray(k)
    for (i in 0..k-1){
     val balloonCosts = readLine()!!.split(" ").toTypedArray().map { it-> it.toInt() }
        var option = arrayOf(0,0);
        val players = readLine()!!.toInt()
        for(j in 1..players){
            val scores= readLine()!!.split(" ").toTypedArray().map{it-> it.toInt()}
            option.set(0, option.get(0) + (scores[0] * balloonCosts[0]) + (scores[1] * balloonCosts[1]))
            option.set(1, option.get(1) + (scores[0] * balloonCosts[1]) + (scores[1] * balloonCosts[0]))
        }
        result.set(i,option.maxOf { it-> it })
    }
    for(el in result){
        println(el)
    }
}
