

fun main() {
    val intArrayOf = intArrayOf(70, 50, 80, 50)

    val toMutableList = intArrayOf.toMutableList()
    val limit = 100
    var count = 0

    for (i in toMutableList.indices.reversed()) {
        for (j in toMutableList.indices.reversed()) {
            val target = toMutableList[i - count]
            val index = j - 1
            if (j - 1 >= 0 && target + toMutableList[index] <= limit) {
                toMutableList.removeAt(i)
                toMutableList.removeAt(index)
                count++
                break
            } else if (index <= 0) {
                toMutableList.removeAt(i - count)
                count++
            }
        }
    }

    println(count)
}