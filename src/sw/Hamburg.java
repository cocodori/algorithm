package sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hamburg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; tc++) {
            int n = sc.nextInt(); // 재료의 수
            int limit = sc.nextInt(); // 제한 칼로리
            List<Ingredient> ingredients = new ArrayList<>();

            for (int i = 0; i < n; i++) ingredients.add(new Ingredient(sc.nextInt(), sc.nextInt()));

            // 모든 경우의 수를 구한다.

        }
    }

    private static class Ingredient {
        private int score;
        private int kcal;

        public Ingredient(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }
    }
}
