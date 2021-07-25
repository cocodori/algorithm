package sw;

import java.util.Scanner;

/**
 *  첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.
 *  이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
 *  각 테스트는 다음과 같이 구성되었다.
 *
 *  [ 입력 ]
 *  첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.
 *  이후 TC개 테스트 케이스가 새 줄로 구분되어 주어진다.
 *  각 테스트 케이스는 다음과 같이 구성되었다.
 *  - 하나의 정수 N이 주어진다. (1 ≤ N ≤ 100)
 *
 *  [ 출력 ]
 *  각 테스트마다
 *      - N 이 1 이상 9 이하의 두수 a, b의 곱으로 표현될 수 있으면 "Yes", 아니면 "No"를 출력하라.
 */
public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            String result = "No";
            for (int i = 1; i < 10; i++) {
                int a = n / i;
                int b = n % i;
                if (b == 0 && a < 10) {
                    result = "Yes";
                    break;
                }
            }
            System.out.format("#%d %s\n", t, result);
        }
    }
}
