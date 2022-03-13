import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] wons = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for (int t = 1; t <= T; t++) {
            int money = sc.nextInt();

            System.out.printf("#%d\n", t);

            for (int won : wons) {
                System.out.printf(money / won + " ");
                money %= won;
            }

            System.out.println();
        }
    }
}
