fun main() {
    val solution = Calculator.timeToCross(2, 10, intArrayOf(7, 4, 5, 6))
    val solution1 = Calculator.timeToCross(100, 100, intArrayOf(10))
    val solution2 = Calculator.timeToCross(100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10))

    println(solution)
    println(solution1)
    println(solution2)
}

object Calculator {
    fun timeToCross(
        bridgeLength: Int,
        weight: Int,
        truckWeights: IntArray
    ): Int {

        var second = 1
        var currentWeight = 0

        var index = 0
        currentWeight += truckWeights[index]
        while (truckWeights.size > ++index) {
            if (weight >= truckWeights[index] + currentWeight) {
                currentWeight += truckWeights[index]
                second++
            } else {
                second += bridgeLength
                currentWeight = 0
            }
        }

        return second + bridgeLength
    }
}