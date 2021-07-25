package lv1

import kotlin.math.sign


/*
*  문제 링크: https://programmers.co.kr/learn/courses/30/lessons/76501
*
*  [문제]
*   어떤 정수들이 있다.
*  이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어진다.
*  실제 정수들의 합을 구하여 return하는 solution함수를 완성한다.
*
*  [제한 사항]
*   - absolutes의 길이는 1 이상 1000 이하다.
*         absolutes의 모든 수는 각각 1 이상 1000이하다.
*
*   - signs의 길이는 absolutes의 길이와 같다.
*       signs[i]가 참이면 absolutes[i]의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미한다.
*
* [입출력 예]
*   absolutes   |       signs           |   result
*   [4, 7, 12]  | [true, false, true]   |       9      4 + (-7) + 12
*   [1, 2,  3]  | [false, false, true]  |       0      (-1) + (-2) + (3)
*
* */
class Add {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var result = 0

        for ((index, sign) in signs.withIndex()) {
            if (!sign) {
                result -= absolutes[index]
                continue
            }

            result += absolutes[index]
        }

        return result
    }

    fun solution2(absolutes: IntArray, signs: BooleanArray): Int =
        absolutes.foldIndexed(0) { idx, acc, num -> acc + if (signs[idx]) num else -num}
}

fun main() {
    val add = Add()
    val solution = add.solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true))
    val solution2 = add.solution2(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true))
    println(solution)
    println(solution2)
}
