package sw;

import java.util.Scanner;

public class Hamburg2 {
    static int n;       // 재료 수
    static int l;       // 제한 칼로리
    static int ans;     // 최대 점수
    static int[] score; // 점수
    static int[] cal;   // 제한 칼로리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            l = sc.nextInt();
            score = new int[n];
            cal = new int[n];
            ans = 0;

            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }

            // 재료 개수, 점수합, 칼로리량 0으로 시작
            dfs(0, 0, 0);

            System.out.format("#%d %d", t, ans);
        }
    }

    static void dfs(int count, int sumScore, int allCal) {
        // 여태 더한 칼로리량이 제한 칼로리보다 클 때
        if (allCal > l) return;

        // n개의 재료까지 뽑았을 경우
        if (count == n) {
            ans = Math.max(ans, sumScore);
            return;
        }

        // 재귀호출(dfs) : 재료수 + 1, 점수, 칼로리 합
        dfs(count+1, sumScore + score[count], allCal + cal[count]);

        // 재료 빼기
        dfs(count + 1, sumScore, allCal);
    }
}
