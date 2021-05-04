//https://www.techiedelight.com/print-triplets-array-sum-less-equal-given-number/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val sut = intArrayOf(2,7,4,9,5,1,3)
    val result = triplets(10, sut)
}

fun triplets(target: Int, sut: IntArray): List<IntArray>{
    var result = emptyList<IntArray>()
    if(target == 0 || sut.isEmpty()){
        return result
    }

    if(sut[0] < target){
        var includeResult = triplets(target- sut[0], sut.filter { x-> x!= sut[0] }.toIntArray())
        for (element in includeResult){
            result = result.plus(element.plus(sut[0]))
        }
    }
    else if(sut[0] == target){
        result = listOf(intArrayOf(sut[0]))
    }
    triplets(target, sut.filter { x-> x!= sut[0] }.toIntArray()).forEach { x-> result = result.plus(x) }
    return result
}

