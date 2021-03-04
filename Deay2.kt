package org.kotlinlang.play

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/

fun main(args: Array<String>){
   var k = readLine()!!.toInt()
    var result = arrayOfNulls<String>(k)
    for(e in 1..k){
        val seatNumber = readLine()!!.toInt()
        val opp = oppositeSeatNumber(seatNumber)
        val seatType = seatType(opp)
        result[e-1] = opp.toString().plus(" ").plus(seatType)
    }
    for(e in 1..k){
        println(result.get(e-1))
    }
}

fun oppositeSeatNumber(seatNumber: Int): Int{
    val remainder = seatNumber % 12
    if(remainder in 1..6){
        val seatDiffHelperArray = arrayOf(11,9,7,5,3,1)
      return seatNumber + seatDiffHelperArray.get(remainder - 1)
    } else {
        val seatDiffHelperArray = arrayOf(11,1,3,5,7,9)
        return seatNumber - seatDiffHelperArray.get(remainder % 6)
    }
}

fun seatType(seatNumber :Int) : String{
    val seatTypeArr = arrayOf("WS","WS", "MS","AS","AS","MS")
    val remainder = seatNumber % 6
    return seatTypeArr.get(remainder)
}
