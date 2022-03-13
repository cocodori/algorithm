import java.util.Scanner;

public class D3합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++)
                numbers[i] = sc.nextInt();
            long maxNumber = getMaxNumber(numbers, N, numbers[N-1]);
            System.out.printf("#%d %d\n", t, maxNumber);
        }
    }

    private static long getMaxNumber(int[] numbers, int length, long maxNumber) {
        long total = 0;
        int last = length == 0 ? numbers[length] : numbers[length-1];
        for (int i = 0; i < length; i++) {
            total += numbers[i];
        }

        maxNumber = Math.max(Math.max(total, maxNumber), last);

        return length == 0 ? maxNumber : getMaxNumber(numbers, --length, maxNumber);
    }
}
