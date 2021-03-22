//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/the-magical-mountain/

fun main(args: Array<String>) {
    val numbers = readLine()!!.toInt()
    val mountains = readLine()!!.split(" ").map { m -> m.toInt() }.toIntArray()
    println(uzairovicMountain(mountains))
}

fun uzairovicMountain(mountains: IntArray): Int {
    var highest = 0
    var ascendingSelections = mutableListOf<Int>()
    for (e in mountains.size - 1 downTo 0) {
        if (highest < mountains[e]) {
            highest = mountains[e]
            ascendingSelections.add(e)
        }
    }
    val resultIndex = (ascendingSelections.size + 1) / 2
    return ascendingSelections[resultIndex]
}
