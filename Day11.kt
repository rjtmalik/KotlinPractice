//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/best-index-1-45a2f8ff/

fun main(args: Array<String>) {
    readLine()
    val inputArr = readLine()!!.split(" ").map { x -> x.toInt() }.toIntArray()
    println(maxSpecialSum(inputArr))
}

fun maxSpecialSum(inputArr: IntArray): Int {
    var result =0
    for((index, value) in inputArr.withIndex()){
        val curretMax= specialSum(inputArr.drop(index))
        result = Math.max(result, curretMax)
    }
    return result
}

fun specialSum(inputArr: List<Int>): Int {
    var result = 0
    var nextExpectedElementCount =1
    var mu = inputArr
    while (nextExpectedElementCount <= mu.size){
        result += mu.take(nextExpectedElementCount).sum()
        mu = mu.drop(nextExpectedElementCount)
        nextExpectedElementCount ++
    }
    return result
}
