//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/maximize-modulo-2-0cb15ded/

fun main(args: Array<String>) {
    val testCases = readLine()!!.toInt()
    var result = mutableListOf<Int>()
    var e = 0
    while (e < testCases) {
        val k = readLine()!!.split(" ")[1].toInt()
        val sut = readLine()!!
        result.add(maxMod(sut, k))
        e++
    }
    result.map { x -> println(x) }
}

fun maxMod(sut: String, k: Int): Int {
    var maxMod = sut.toInt() % k
    for (e in sut.indices) {
        val sutInt = sut.removeRange(e, e + 1).toIntOrNull() ?: 0
        val mod = sutInt % k
        if (maxMod < (mod)) {
            maxMod = mod
        }
    }
    return maxMod
}
