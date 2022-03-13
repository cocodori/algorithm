package leetcode

/**
 * 당신은 제품 관리자이며, 현재 신제품 개발팀을 이끌고 있다.
 * 불행하게도, 최신 버전 제품은 퀄리티 체크에 실패했다.
 * 각 버전은 이전 버전을 기반으로 개발한ㄷ. 따라서 실패한 버전 이후의 모든 버전은 실패한 버전이다.
 *
 * n개의 버전 [1, 2, 3, ... , n]이 있다.
 * 첫 번째 잘못된 버전을 찾아야 한다.
 *
 * 상위클래스에서 bad 버전인지 아닌지 판별하는 isBadVersion(version)이라는 API를 제공한다.
 * 아무튼 이걸로 bad version을 구하라.
 * bad version의 위치 아니고, isBadVersion을 호출한 횟수 아니고 bad version 그 자체를 반환하라.
 */
abstract class VersionControl() {
    fun isBadVersion(version: Int): Boolean {
        if (version >= 4) return false
        return true
    }

    abstract fun firstBadVersion(n: Int): Int
}
class FirstBadVersion: VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n-1
        var pivot = calculatePivot(left, right)

        while (left <= right) {
            //bad version이라면 왼쪽으로 가서 더 앞선 배드 버전이 있는지 탐색
            if (isBadVersion(pivot)) {
                right = pivot-1
                pivot = calculatePivot(left, right)
            }
            else { //배드 버전이 아니라면 오른쪽으로 가서 배드 버전을 탐색
                left = pivot+1
                pivot = calculatePivot(left, right)
            }
        }
        return pivot
    }

    private fun calculatePivot(left: Int, right: Int) = left + (right - left) / 2

}

fun main() {
    val firstBadVersion = FirstBadVersion().firstBadVersion(5)
    println(firstBadVersion)
}