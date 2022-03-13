package sw;

import java.io.IOException;
import java.util.Scanner;

public class Hamburg3 {
    static int TC, N, L, ans;
    static int[] score;
    static int[] kal;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt(); // 재료의 수
            L = sc.nextInt(); // 칼로리 제한
            score = new int[N];
            kal = new int[N];

            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                kal[i] = sc.nextInt();
            }

            ans = 0;
            dfs(0, 0, 0);

            System.out.format("#%d %d", tc, ans);
        }
    }

    private static void dfs(int count, int sco, int kcal) {
        if (kcal > L) return;
        if (count == N) {
            ans = Math.max(ans, sco);
            return;
        }
        dfs(count + 1, sco + score[count], kcal + kal[count]);
        dfs(count + 1, sco, kcal);
    }
}
