package leetcode

/**
 * 문자열 's'와 't'가 주어진다.
 * 's'가 't'의 subsequence라면 true, 아니라면 false를 반환한다.
 */
class Subsequence {
    fun isSubsequence(): Boolean {
        val s = "ab"
        val t = "baab"
        val reversed = t.reversed()
        var prevIndex = t.length

        for (c in s.toCharArray()) {
            val currentIndex = reversed.lastIndexOf(c)
            if (prevIndex > currentIndex && currentIndex != -1) {
                prevIndex = currentIndex
            } else {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Subsequence2().isSubsequence("ab", "baab"))
}

class Subsequence2 {
    /**
     * - 's'가 empty string이라면 true다. t의 모든 문자가 subsequence가 된다.
     * - 's'를 char array로 변환한 다음 첫 번째 인덱스(currentSIndex = 0)를 지정한다.
     * - 't'도 char array로 변경하고 왼쪽(0)부터 오른쪽(마지막 인덱스)으로 탐색한다.
     *      - 's'의 문자를 찾을 때마다 currentSIndex를 증가시킨다.
     *      - currentSIndex와 s의 길이가 같다면 모두 찾았다는 것이므로 sub sequence라고 판단한다.
     */
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        var currentSIndex = 0

        val sChars = s.toCharArray()
        val tChars = t.toCharArray()

        for (i in t.indices) {
            if (sChars[currentSIndex] == tChars[i])
                currentSIndex++
            if (currentSIndex == s.length)
                return true
        }

        return false
    }
}