package sw;

import java.util.Scanner;

public class 달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int[][] list = save(new int[n][n], 1, 0);

            System.out.printf("#%d\n", t);
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list.length; j++) {
                    System.out.print(list[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    private static int[][] save(int [][] list, int acc, int loopCnt) {
        // 오른쪽
        for (int j = 0 + loopCnt; j < list.length - loopCnt; j++) {
            list[loopCnt][j] = acc++;
        }

        // 아래쪽
        for (int i = 1 + loopCnt; i < list.length - loopCnt; i++) {
            list[i][list.length-1-loopCnt] = acc++;
        }

        // 왼쪽
        for (int j = list.length - 2 - loopCnt; j >= 0+loopCnt; j--) {
            list[list.length-1-loopCnt][j] = acc++;
        }

        // 위쪽
        for (int i = list.length - 2 - loopCnt; i > 0+loopCnt; i--) {
            list[i][0 + loopCnt] = acc++;
        }

        return acc > list.length * list.length ? list : save(list, acc, ++loopCnt);
    }
}
