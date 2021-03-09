//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/

fun main(args: Array<String>) {
    val sut = readLine()!!
    when (IsPalindrome(sut)) {
        true -> print("YES")
        false -> print("NO")
    }
}

fun IsPalindrome(sut: String): Boolean {
    for (i in 0 until sut.length / 2) {
        if (sut[i] != sut[sut.length - 1 - i]) {
            return false
        }
    }
    return true;
}
