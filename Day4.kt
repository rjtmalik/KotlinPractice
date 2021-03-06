import kotlin.math.abs
//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/

fun main(args: Array<String>) {
    val testCases = readLine()!!.toInt()
    var result = IntArray(testCases)
    for (testCase in 0 until testCases) {
        val a = readLine() as String
        val b = readLine() as String
        result.set(testCase, DeletionsToDo(GetMap(a), GetMap(b)))
    }
    for (testCase in 0 until testCases) {
         println(result[testCase])
    }
}

fun DeletionsToDo(a: Map<Char, Int>, b: Map<Char, Int>) : Int{
    var result = 0
    for ((key, value) in a){
        if(!b.containsKey(key)){
            result +=value
        }
        else{
            result+= abs(value - b[key]!!)
        }
    }
    for ((key, value) in b){
        if(!a.containsKey(key)){
            result +=value
        }
    }
    return result;
}

fun GetMap(inputStr: String): Map<Char, Int> {
    var result = mutableMapOf<Char, Int>()
    for ((index, value) in inputStr.withIndex()) {
        if (result.containsKey(value)) {
            val k = result[value]!!.plus(1)
            result[value] = k
        } else {
            result.put(value, 1)
        }
    }
    return result
}
