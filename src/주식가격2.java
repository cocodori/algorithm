import kotlin.jvm.internal.Intrinsics;

import java.util.Arrays;

class 주식가격솔루션 {
    public final int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        int priceSize = prices.length;

        for (int i = 0; i < priceSize; i++) {
            int price = prices[i];
            int count = 0;

            for (int j = i + 1; j < priceSize; j++) {
                boolean isNotIncrease = price <= prices[j];
                if (isNotIncrease) {
                    count++;
                } else {
                    if (i == priceSize-1) {
                        count++;
                        result[i] = count;
                        break;
                    }
                }
            }

            result[i] = count;
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}

public final class 주식가격2 {
    public static final void main() {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        (new 주식가격솔루션()).solution(prices);
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
        main();
    }
}
