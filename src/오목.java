import java.util.Scanner;

public class 오목 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int boardSize = sc.nextInt();
            String[] next = new String[boardSize];

            for (int i = 0; i < boardSize; i++) next[i] = sc.next();

            Board board = new Board(next);

            System.out.printf("#%d %s\n", t, board.isStraight() ? "YES" : "NO");
        }
    }
}

class Board {
    private boolean[][] exist;

    public Board(String[] lines) {
        int length = lines.length;
        this.exist = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            String line = lines[i];
            String[] split = line.split("");

            for (int j = 0; j < length; j++) {
                if (split[j].equals(".")) {
                    exist[i][j] = false;
                } else if (split[j].equals("o")) {
                    exist[i][j] = true;
                } else {
                    throw new IllegalArgumentException("잘못된 입력값");
                }
            }
        }
    }

    public boolean isStraight() {
        for (int i = 0; i < exist.length; i++) {
            for (int j = 0; j < exist.length; j++) {

                if (exist[i][j]) {
                    if(exist.length > (i + 4)) { //세로 탐색
                        int count = 0;

                        for (int row = i + 1; row < i+5; row++) {
                            if (exist[row][j]) count++;
                        }

                        if (count >= 4) return true;

                    }

                    if ((j - 4) >= 0 && exist.length > i + 4) { // 왼쪽 아래 대각선 탐색
                        // row + 1, column - 1
                        int column = j;
                        int count = 0;

                        for (int row = i+1; row < i+5; row++) {
                            if (exist[row][--column]) count++;
                        }

                        if (count >= 4) return true;

                    }

                    if (exist.length > j + 4 && exist.length > i + 4) { //오른쪽 아래 대각선 탐색
                        // row + 1, column + 1
                        int column = j;
                        int count = 0;

                        for (int row = i+1; row < i+5; row++) {
                            if (exist[row][++column]) count++;
                        }

                        if (count == 4) return true;
                    }

                    if (exist.length > (j + 4)) { //가로 탐색://오른쪽으로 4자리 공간이 남아있다면

                        int count = 0;

                        for (int column = j + 1; column < j+5; column++) {
                            if (exist[i][column]) count++;
                        }

                        if (count >= 4) return true;
                    }
                }
            }
        }
        return false;
    }
}
