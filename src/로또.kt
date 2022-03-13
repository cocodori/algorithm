class Solution {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return Lotto(lottos).calculateRank(winNums)
    }
}

class Lotto(private val lottos: IntArray) {
    fun calculateRank(winNums: IntArray): IntArray {
        var rank = 1
        var zeroCount  = 0

        lottos.forEachIndexed { i, num ->
            if (num == 0)
                zeroCount++
            else if(!winNums.contains(num))
                rank++
        }

        if (rank == 7) rank -= 1
        if (zeroCount == 6) zeroCount -= 1

        return intArrayOf(rank, rank + zeroCount)
    }
}