import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭2 {
    static Integer[][] dp;
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int STUFF_SIZE = Integer.parseInt(st.nextToken());
        final int WEIGHT_LIMIT = Integer.parseInt(st.nextToken());

        weights = new int[STUFF_SIZE];
        values = new int[STUFF_SIZE];

        dp = new Integer[STUFF_SIZE][WEIGHT_LIMIT + 1];

        for (int i = 0; i < STUFF_SIZE; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(STUFF_SIZE - 1, WEIGHT_LIMIT));
    }

    private static int knapsack(int i, int weightLimit) {
        //i가 0 미만 -> 범위 밖
        if (i < 0)
            return 0;

        //탐색하지 않은 위치라면
        if (dp[i][weightLimit] == null) {
            //현재 물건(i)을 추가로 못담는 경우
            if (weights[i] > weightLimit) {
                dp[i][weightLimit] = knapsack(i - 1, weightLimit);
            } else { //현재 물건을 담을 수 있는 경우
                //이전 i값과 이전 i값에 대한 limit-weights[i]의 값 + 현재 가치(values[i]) 중 큰 값을 저장
                dp[i][weightLimit] = Math.max(
                        knapsack(i - 1, weightLimit),
                        knapsack(i - 1, weightLimit - weights[i]) + values[i]);
            }
        }
        return dp[i][weightLimit];
    }
}
