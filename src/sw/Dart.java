package sw;

import java.util.Scanner;

/**
 *  보드는 중심이 원점이고 반지름이 20, 40, 60, 80, 100, 120, 140, 160, 180, 200인 10개의 원이 그려져 있다.
 *  각각의 화살은 꽂힌 지점을 감싸는 가장 가까원 원(경계선에 꽂힌 경우도 포함)의 반지름이 20 * (11 - p)인 경우 p점을 획득한다. (1 ≤ P ≤ 10)
 *  만약 가장 큰 원 바깥에 꽂혔다면 얻는 점수는 없다. N 개의 화살을 던진 위치가 주어지면, 총 몇 점을 얻었는지 계산하라.
 *
 *  [ 입력 ]
 *      첫 번째 줄에 테스트케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
 *      각 테스트 케이스는 다음과 같이 구성되었다.
 *          - 첫 번째 정수는 화살의 개수 N이다. (1 ≤ N ≤ 1000000)
 *          - 이후 화살이 떨어진 위치 x,y가 두 정수로 주어진다. (-200 ≤ x, y ≤ 200)
 *  [ 출력 ]
 *      각 테스트 케이스마다 점수의 합을 출력한다.
 */
public class Dart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int numberOfArrows = sc.nextInt();
            int score = 0;

            for (int i = 0; i < numberOfArrows; i++) {
               int x = sc.nextInt();
               int y = sc.nextInt();

               double distance = Math.sqrt(x * x + y * y);

               for (int r = 1; r<=10; r++) {
                   if (distance <= r * 20) {
                       score += 11 - r;
                       break;
                   }
               }
            }
            System.out.format("#%d %d\n", tc, score);
        }
    }
}
