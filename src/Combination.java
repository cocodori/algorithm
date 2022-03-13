import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        boolean[] visited = new boolean[n];

        System.out.println("\n" + n + "개 중에서 " + 3 + "개 뽑기");
        comb(arr, visited, 0, n, 3);
    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 재귀 사용
    // 사용 예시 : comb(arr, visited, 0, n, r)
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        if (depth == n) return;

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
