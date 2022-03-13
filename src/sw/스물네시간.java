package sw;

import java.util.Scanner;

public class 스물네시간 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = (a + b) > 24 ? (a+b) - 24 : (a+b);

            System.out.printf("#%d %d\n",t, result == 24 ? 0 : result);
        }
    }
}
