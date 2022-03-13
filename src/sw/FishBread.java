package sw;

import java.util.Arrays;
import java.util.Scanner;

public class FishBread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            boolean isPossible = false;
            int n = sc.nextInt();   // n 명의 손님
            int m = sc.nextInt();   // 붕어빵을 만드는 데 드는 시간
            int k = sc.nextInt();   // m의 시간 동안 만들 수 있는 붕어빵의 개수

            int[] arrivalTimes = new int[n];
            for (int j = 0; j < n; j++) arrivalTimes[j] = sc.nextInt();
            Arrays.sort(arrivalTimes);
            int accumulator = 0;
            for (int arrivalTime : arrivalTimes) {
                if (arrivalTime >= m) {
                    int totalItemCount = (arrivalTime / m) * k;
                    if (totalItemCount > accumulator) {
                        isPossible = true;
                        accumulator++;
                    } else {
                        isPossible = false;
                        break;
                    }
                } else break;
            }
            System.out.format("#%d %s\n", t, isPossible ? "Possible" : "Impossible");
        }
    }
}


