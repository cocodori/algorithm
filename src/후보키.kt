class 후보키 {
}

fun main() {
    val relation: Array<Array<String>> = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2"),
    )

    var result = 0
    var isBreak = false

    for (i in 0 until relation[0].size) {
        for (j in relation.indices) {
            if (isBreak) {
                isBreak = false
                break
            }
            for (k in (j+1) until relation.size) {
                println("($j $i) == ($k $i)")

                if (relation[j][i] == relation[k][i]) {
                    result++
                    println(relation[k][i])
                    println()
                    isBreak = true
                    break
                }
            }
        }
    }
}