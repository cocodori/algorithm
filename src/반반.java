import java.util.Scanner;

public class 반반 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++)
            System.out.printf("#%d %s\n", t, CharsetUtils.solution(sc.next()) ? "Yes" : "No");
    }
}

class CharsetUtils {
    public static boolean solution(String input) {
        String[] charset = input.split("");

        int count = 0;

        for (int i = 0; i < charset.length; i++)
            for (int j = i+1; j < charset.length; j++)
                if (charset[i].equals(charset[j]) ) count++;

        return count == 2;
    }
}