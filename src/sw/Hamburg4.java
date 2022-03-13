package sw;

import java.util.Scanner;

public class Hamburg4 {
    static int N;
    static int L;
    static int ans;
    static int[] score;
    static int[] cal;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int t = 1; t <= TC; t++) {
            N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N];
            cal = new int[N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            dfs(0, 0, 0);

            System.out.format("#%d %d\n", t, ans);
        }
    }

    private static void dfs(int count, int sumScore, int allCal) {
        // 여태 더한 칼로리량이 제한 칼로리보다 클 경우
        if (allCal > L) return;
        // N개의 재료까지 뽑았을 경우 -> 최대 점수 비교
        if (count == N) {
            ans = Math.max(ans, sumScore);
            return;
        }

        // 재귀 호출 : 재료수 + 1, 점수, 칼로리합
        dfs(count+1, sumScore + score[count], allCal + cal[count]);
        // 재료 빼기
        dfs(count+1, sumScore, allCal);
    }
}