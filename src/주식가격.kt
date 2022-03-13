import java.util.*

class 주식가격 {
    fun solution(prices: IntArray) {
        val result = IntArray(prices.size)
        for ((i, price) in prices.withIndex()) {
            var count = 0
            for (j in (i+1) until prices.size) {
                val isNotIncrease = price <= prices[j]
                if (isNotIncrease) {
                    count++
                }
            }
            result[i] = count
        }
    }
}

fun main() {
    val prices = intArrayOf(1, 2, 3, 2, 3)
    주식가격().solution(prices)
}