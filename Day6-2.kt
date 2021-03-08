//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/modify-the-string/

fun main(args: Array<String>) {
    val inputStr = readLine()!!
    println(Toggle(inputStr))
}

private fun Toggle(inputStr: String): String {
    var result: StringBuilder =StringBuilder(inputStr.length)
    for ((i, value) in inputStr.withIndex()) {
        val asciiCode = value.toInt()
        if (asciiCode > 96) {
            result.append(value.toUpperCase())
        } else {
            result.append(value.toLowerCase())
        }
    }
    return result.toString()
}
