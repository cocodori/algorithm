import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연속되는_자연수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int contiguousCount = 0;

            for (int i = 1; i <= N; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                if (isContiguousNumber(N, i, list))
                    contiguousCount += 1;
            }
            System.out.printf("#%d %d\n", t, contiguousCount);
        }
    }

    private static boolean isContiguousNumber(int originNumber, int lastNumber, List<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        if (sum == originNumber)
            return true;
        else if (sum < originNumber) {
            lastNumber += 1;
            list.add(lastNumber);
            return isContiguousNumber(originNumber, lastNumber, list);
        }

        return false;
    }
}
