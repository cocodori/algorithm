import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소득불균형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int count = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(sc.nextInt());
            }
            double average = list.stream()
                    .mapToDouble(a -> a)
                    .average()
                    .orElseThrow();

            long result = list.stream()
                    .filter(n -> average >= n)
                    .count();

            System.out.printf("#%d %d\n", t, result);
        }
    }
}
