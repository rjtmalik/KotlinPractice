//https://www.techiedelight.com/find-minimum-number-deletions-convert-string-into-palindrome/

package org.kotlinlang.play

import java.util.*

fun main(args: Array<String>) {
    val sut = "ACBCDBAA"
    val result = getPalindrome(sut)
}

fun getPalindrome(sut: String): String {
    if (sut.length == 1) return sut
    if (sut[0] == sut[sut.length - 1]) {
        return sut[0].toString() + getPalindrome(sut.substring(1, sut.length - 1)) + sut[0].toString()
    } else {
        val opt1 = getPalindrome(sut.substring(1))
        val opt2 = getPalindrome(sut.substring(0, sut.length - 1))
        if (opt1.length > opt2.length)
            return opt1
        else
            return opt2
    }
}
