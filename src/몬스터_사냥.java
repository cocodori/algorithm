import java.util.Scanner;

public class 몬스터_사냥 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int D = sc.nextInt();
            int L = sc.nextInt();
            int N = sc.nextInt();
            long result = 0;

            for (int i = 0; i < N; i++) {
                result += D * (1 + (i * 0.01 * L));
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }
}
