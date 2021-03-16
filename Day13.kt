//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/golf/distinct-count-2/

fun main(args: Array<String>) {
    readLine()!!
    val sut = readLine()!!.split(" ").map { x -> x.toInt() }.toIntArray()
    println(maximumFrequencyNumIn(sut))
}

fun maximumFrequencyNumIn(sut: IntArray): Int {
    var map = mutableMapOf<Int, Int>()
    var maxOccurence = 0;
    var result = 0
    for (e in sut) {
        if (map.containsKey(e)) {
            val occ = map[e]!!.plus(1)
            map[e] = occ
            if (occ > maxOccurence) {
                maxOccurence = occ
                result = e
            }
        } else {
            map.put(e, 1)
            if (1 > maxOccurence) {
                maxOccurence = 1
                result = e
            }
        }
    }
    return result
}
