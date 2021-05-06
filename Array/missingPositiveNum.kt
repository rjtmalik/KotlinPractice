//https://www.techiedelight.com/find-smallest-missing-positive-number-unsorted-array/

package org.kotlinlang.play

fun main(args: Array<String>) {
    val sut = intArrayOf(1,4,2,3,-1,6)
    val result = missingPositiveNum(sut)
}

fun missingPositiveNum(sut: IntArray): Int{
    var parsed = HashSet<Int>()
    var searching = HashSet<Int>()
    for(e in sut){
        if(searching.contains(e)){
            searching.remove(e)
        }
        val previous = e -1
        val next = e +1
        if(!searching.contains(previous) && !parsed.contains(previous) && previous > 0){
            searching.add(previous)
        }
        if(!searching.contains(next) && !parsed.contains(next)  && next > 0){
            searching.add(next)
        }
        parsed.add(e)
    }
    var min = Int.MAX_VALUE
    for (e in searching){
        if(e < min ){
            min = e
        }
    }
    return min
}


