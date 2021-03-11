//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cipher-1/

fun main(args: Array<String>) {
    val plainText = readLine()!!
    val rotations = readLine()!!.toInt()
    println(rotate(plainText, rotations))
}

fun rotate(plainText: String, rotations: Int): String {
    val builder: StringBuilder = StringBuilder()
    for ((index, value) in plainText.withIndex()) {
        if (value.isLetter()) {
            val impactfulRotations = rotations % 26
            val currentIndex = value.toLowerCase().toInt()
            val distanceToZ = 122 - currentIndex
            var charIndex = 0;
            if (distanceToZ > impactfulRotations) {
                charIndex = currentIndex + impactfulRotations
            }
            else if(distanceToZ == impactfulRotations){
                charIndex = 122
            }
            else {
                charIndex = 96 + if(distanceToZ ==0) impactfulRotations else impactfulRotations - distanceToZ
            }
            if (value.isLowerCase()) {
                builder.append(charIndex.toChar())
            } else {
                builder.append(charIndex.toChar().toUpperCase())
            }
        } else if (value.isDigit()) {
            builder.append((48 + (Character.getNumericValue(value) + rotations) % 10).toChar())
        } else {
            builder.append(value)
        }
    }
    return builder.toString()
}
