package sw;

import java.util.*;
import java.util.stream.Collectors;

public class 새샘이의735게임 {
    static Set<Integer> answer = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();
        final int length = 7;
        final int countOfCombination = 3;
        final int depth = 0;

        int[] numbers = null;
        boolean[] visited = null;

        for (int t = 1; t <= T; t++) {
            numbers = new int[length];
            visited = new boolean[length];
            answer = new HashSet<>();
            for (int i = 0; i < length; i++) numbers[i] = sc.nextInt();
            combination(numbers, visited, depth, length, countOfCombination);
            List<Integer> sortedAnswer = answer.stream().sorted((o1, o2) -> o1 > o2 ? -1 : 1).collect(Collectors.toList());
            System.out.format("#%d %d\n", t, sortedAnswer.get(4));
        }
    }

    private static void combination(int[] arr, boolean[] visited, int depth, int length, int countOfCombination) {
        if (countOfCombination == 0) {
            calculate(arr, visited, length);
            return;
        }
        if (depth == length) return;

        visited[depth] = true;
        combination(arr, visited, depth + 1, length, countOfCombination - 1);
        visited[depth] = false;
        combination(arr, visited, depth + 1, length, countOfCombination);
    }

    private static void calculate(int[] arr, boolean[] visited, int length) {
        int total = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i])
                total += arr[i];
        }
        answer.add(total);
    }
}
