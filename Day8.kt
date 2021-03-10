//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/make-all-equal-90a21ab2/

fun main(args: Array<String>) {
    readLine()
    val arrA = toIntArray(readLine()!!)
    val arrB = toIntArray(readLine()!!)
    println(getSteps(arrA,arrB))
}

fun getSteps(arrA: IntArray, arrB: IntArray): Int {
    var min = arrA.minOf { x -> x }
    while (min > 0) {
        val steps = getStepsForMin(min, arrA, arrB)
        if (steps == -1) {
            min -= 1
        } else {
            return steps
        }
    }
    return -1;
}

fun getStepsForMin(min: Int, arrA: IntArray, arrB: IntArray): Int {
    var result = 0
    for ((index, value) in arrA.withIndex()) {
        var changingValue = value;
        while (changingValue > min && value > arrB[index]) {
            changingValue -= arrB[index]
            result += 1
        }
        if (min != changingValue) return -1
    }
    return result
}

fun toIntArray(inputStr: String): IntArray {
    val inputArr = inputStr.split(" ")
    var result = IntArray(inputArr.size)
    for ((index, value) in inputArr.withIndex()) {
        result[index] = value.toInt()
    }
    return result;
}
