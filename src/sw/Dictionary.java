package sw;

import java.util.Scanner;

/**
 * 영어 알파벳으로 만들 수 있는 모든 단어가 수록된 무한 사전이 있다.
 * 두 단어 P, Q가 주어질 때, 사전 상에서 P와 Q 사이에 다른 단어가 있는지 없는지 판별하는 프로그램을 작성하라.
 * <p>
 * [ 입력 ]
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 * 각 테스트 케이스 첫 줄에는 알파벳 소문자로 이루어진 단어 P가 주어진다.
 * <p>
 * 두 번째 줄에는 알파벳 소문자로 된 단어 Q가 주어진다.
 * <p>
 * P와 Q사이의 길이는 1 이상 10이하다. P는 Q보다 사전 상 먼저 오는 단어다.
 * (단, 사전에는 10자보다 더 긴 단어가 존재할 수 있다)
 */
public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            sb.append("#").append(t).append(" ");
            String a = sc.next().trim() + "a";
            String b = sc.next().trim();
            // 첫 번째 단어가 두 번째 단어보다 사전상 앞 단어
            // 첫 번째 단어 뒤에 a를 붙이면 바로 다음 단어
            // 이 단어와 두 번째 단어가 같으면 N
            if (a.equals(b)) {
                sb.append("N\n");
                continue;
            }
            sb.append("Y\n");
        }
        System.out.println(sb);
    }
}
