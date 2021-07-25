package sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
 * 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작한다.
 * 여기서 '최빈수'란 특정 자료에서 가장 여러 번 나타내는 값을 말한다.
 * <p>
 * 다음과 같은 수 분포가 있다고 하자.
 * [10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3]
 * 이때 최빈수는 8이 된다.
 * 최빈수를 출력하는 프로그램을 작성하라.
 * <p>
 * [ 제약 사항 ]
 * 학생 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하다.
 * <p>
 * [ 입력 ]
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 * 각 테스트 케이스 첫 줄에는 테스트 케이스의 번호가 주어지고,
 * 그 다음 줄부터 점수가 주어진다.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //첫 번째 입력은 테스트 케이스의 수 T
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            // Map 이용 - Key: 점수, Value: 빈도
            // 1. 해당 점수의 Key가 있는 지 확인
            // Y: Value + 1, N: key를 등록하고 Value = 1
            Map<Integer, Integer> scoreMap = new HashMap();
            int testNumber = sc.nextInt();

            for (int j = 1; j <= 1000; j++) {
                int score = sc.nextInt();

                if (!scoreMap.containsKey(score)) {
                    scoreMap.put(score, 1);
                    continue;
                }

                Integer frequency = scoreMap.get(score);

                scoreMap.put(score, frequency + 1);
            }

            Integer mode = scoreMap.entrySet()
                    .stream()
                    .max((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1)
                    .get()
                    .getKey();

            System.out.println("#"+testNumber+" "+mode);
        }

    }
}
