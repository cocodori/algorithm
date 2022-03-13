package sw;

import java.util.Scanner;

import static java.lang.Math.max;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int buildingCount = sc.nextInt();
            int[] height = new int[buildingCount];
            int result = 0;
            for (int i = 0; i < buildingCount; i++) height[i] = sc.nextInt();

            for (int i = 2; i < height.length - 2; i++) {
                int current = height[i];
                int before = height[i - 1];
                int afterBefore = height[i - 2];
                int next = height[i + 1];
                int afterNext = height[i + 2];

                /**
                 * 조망권이 확보 되었다면, 현재 - 1, - 2 위치에 있는 건물 && 현재 + 1, + 2 위치에 있는 건물 중에 가장 높은 층을 찾는다.
                 * 현재 - 조망권 중 가장 높은 층 = 조망권 세대수
                 * 조망권 중 현재가 가장 높은 세대니 + 2까지는 조망권 세대가 아니므로 index + 2 증가.
                 */
                boolean hasView = (current > next && current > afterNext) && (current > before && current > afterBefore);
                if (hasView) {
                    result += current - max(max(before, afterBefore), max(next, afterNext));
                    i += 2;
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }
}
