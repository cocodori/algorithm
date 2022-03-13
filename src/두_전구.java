import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 두_전구 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            List<Integer> result = new ArrayList<>();

            for (int i = a; i < b; i++) {
                for (int j = c; j < d; j++) {
                    if (i == j) result.add(i);
                }
            }

            System.out.printf("#%d %d\n", t, result.size());
        }
    }
}
