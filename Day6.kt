//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/

fun main(args: Array<String>) {
    val width = readLine()!!.toInt()
    val number = readLine()!!.toInt()
    var result = arrayOfNulls<String>(number)
    for (e in 0 until number) {
        result[e] = ValidatePhoto(readLine()!!, width)
    }
    for (e in 0 until number) {
        println(result[e])
    }
}
//random comment

private fun ValidatePhoto(dimensions: String, width: Int): String {
    val splitDim = dimensions.split(" ")
    val w = splitDim[0]!!.toInt()
    val l = splitDim[1]!!.toInt()

    var result = ""
    result = if (l >= width && w >= width && w == l) {
        "ACCEPTED"
    } else if (l >= width && w >= width && w != l) {
        "CROP IT"
    } else {
        "UPLOAD ANOTHER"
    }
    return result
}
