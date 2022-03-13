package sw;

import java.math.BigInteger;
import java.util.Scanner;

public class 유효숫자표기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            // N은 10^100000까지 들어올 수 있어서 long으로도 커버 안 됨
            BigInteger n = sc.nextBigInteger();
            double timesNumber; // n을 일의 자리 소수로 만든 결과
            int numberOfDigit = n.toString().length()-1; // 자리수

            //자리수 만큼 루프를 돌면서 n을 일의 자리 수로 만들 수 있는 소수를 생성
            double d = 0.1;
            for (int i = 1; i < numberOfDigit; i++) { d *= 0.1; }

            timesNumber = n.doubleValue() * d;

            // 소수점 두 번째 자리에서 반올림
            double rounds = (double) Math.round(timesNumber * 10) / 10;

            // 99999 같은 경우 고려
            if (rounds == 10.0) {
                numberOfDigit = numberOfDigit + 1;
                rounds = 1.0;
            }

            System.out.format("#%d %1.1f*10^%d\n", t, rounds, numberOfDigit);
        }
    }
}
