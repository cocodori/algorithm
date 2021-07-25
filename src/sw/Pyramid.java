package sw;


import java.util.*;

/**
 *  경표는 아래와 같이 삼각형 모양으로 숫자를 쌓기로 했다.
 *  1층에는 1개, 2 층에는 3개, 3층에는 5개, 4층에는 ...와 같이 쌓는다.
 *
 *              1
 *            3 5 7
 *         9 11 13 15 17
 *     19 21 23 25 27 29 31
 *
 *  이처럼, 경표가 끝도 없이 피라미드를 쌓는다고 가정할 때, N층의 제이 왼쪽, 오른쪽에 쓰게 될 숫자가 무엇일 지 예측해야 한다.
 *
 *
 *  [ 압력 ]
 *
 *      첫 번째 줄에는 테스트 케이스의 수 T가 주어진다.
 *
 *      각 테스트 케이스의 첫 번째 줄에는 층의 번호 N(1 ≤ N ≤ 10^9)이 주어진다.
 *
 *
 *  [ 출력 ]
 *
 *      각 테스트 케이스마다 '#x'(x는 테스트 케이스의 번호를 의미, 1부터 시작)를 출력하고
 *
 *      각 테스트 케이스마다 N층의 제일 왼쪽, 오른쪽에 쓰게 될 숫자를 공백으로 구별하여 출력한다.
 *
 */
public class Pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Test cases

        for (int testCaseNumber = 1; testCaseNumber <= T; testCaseNumber++) {
            long n = sc.nextLong();
            long min = (n-1) * (n-1) * 2 + 1;
            long max = (n * n * 2) - 1;
            System.out.println(String.format("#%d %d %d", testCaseNumber, min, max));
        }
    }
}