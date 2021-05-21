package lv1


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
    /*
    *   signs가 true면 양수
    *   signs가 false면 음수
    * */
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var result: Int = 0

        for (index in signs.indices) {
            if (!signs[index]) {
                result -= absolutes[index]
                continue
            }

            result += absolutes[index]
        }

        return result
    }
}

fun main() {
    val add = Add()
    val solution = add.solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true))
    println(solution)
}
