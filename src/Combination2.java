public class Combination2 {
    public static void main(String[] args) {
        System.out.println(combination(3, 2));
    }

    private static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    static void combinationWithBacktracking(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combinationWithBacktracking(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void combinationWithRecursive(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        if (depth == n) return;

        visited[depth] = true;
        combinationWithRecursive(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        combinationWithRecursive(arr, visited, depth + 1, n, r);
    }


    private static void print(int[] arr, boolean[] visited, int n) {
    }
}
