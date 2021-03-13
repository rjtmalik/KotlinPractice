package org.kotlinlang.play

import java.lang.Exception
import java.lang.StringBuilder

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/

fun main(args: Array<String>) {
    val k = readLine()!!.toInt()
    val result = mutableListOf<String>()
    for (e in 0 until k) {
        readLine()
        val inputStr = readLine()!!
        result.add(dhananjayStringFor(inputStr))
    }
    result.map { x -> println(x) }
}

fun dhananjayStringFor(inputStr: String): String {
    var result = StringBuilder()
    val primeUStatus = getPrimeForAllUpperCaseAlphabets().toMap()
    val primeLStatus = getPrimeForAllLowerCaseAlphabets().toMap()
    for ((index, value) in inputStr.withIndex()) {
        var primes:Map<Int, Boolean>
        if(value.isLowerCase()){
            primes = primeLStatus
        }
        else{
            primes = primeUStatus
        }
        if (primes[value.toInt()] == true) {
            result.append(value)
        } else {
            result.append(nearestPrime(value, primes))
        }
    }
    return result.toString()
}

fun nearestPrime(sut: Char, map: Map<Int, Boolean>): Char {
    val result = 0
    var next = sut.toInt() + 1
    var prev = sut.toInt() - 1
    while (result == 0) {
        if (map.containsKey(prev) && map[prev] == true) {
            return prev.toChar()
        } else if (map.containsKey(next) && map[next] == true) {
            return next.toChar()
        } else {
            prev--
            next++
        }
    }
    throw Exception("could not find any prime")
}

fun getPrimeForAllUpperCaseAlphabets(): MutableMap<Int, Boolean> {
    var result = mutableMapOf<Int, Boolean>()
    for (i in 65..91) {
        result.set(i, isPrime(i))
    }
    return result
}

fun getPrimeForAllLowerCaseAlphabets(): MutableMap<Int, Boolean> {
    var result = mutableMapOf<Int, Boolean>()
    for (i in 97..123) {
        result.set(i, isPrime(i))
    }
    return result
}

fun isPrime(sut: Int): Boolean {
    for (i in 2..(sut / 2 + 1)) {
        if (sut % i == 0) return false
    }
    return true
}
