package boj

class Boj4375 {
}

fun main() = with(System.`in`.bufferedReader()) {
    println(1 % 3)
    val input = readLine()
    while(input != null) {
        println(findDigit(input))
    }
}

private fun findDigit(input: String): Int {
    var num: Long = 1
    var result = 1
    while (true) {
        val isZero = num % input.toInt() == 0L
        if (isZero) {
            return result
        }

        num = (num * 10) + 1
        result++
    }
}