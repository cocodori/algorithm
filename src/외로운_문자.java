import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 외로운_문자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int t = 1; t <= TC; t++)
            System.out.printf("#%d %s\n", t, LonelyCharacter.stringParser(sc.next()));
    }
}

class LonelyCharacter {
    public static String stringParser(String str) {
        char[] strToChars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Integer> checkIndexes = new HashSet<>();

        for (int i = 0; i < strToChars.length; i++) {
            for (int j = 1; j < strToChars.length; j++) {
                if (strToChars[i] == strToChars[j]
                        && i != j && isNotContains(checkIndexes, i) && isNotContains(checkIndexes, j)) {
                    checkIndexes.add(i);
                    checkIndexes.add(j);
                    break;
                }
            }

            if (isNotContains(checkIndexes, i))
                sb.append(strToChars[i]);
        }

        if (sb.toString().equals(""))
            return "Good";

        char[] resultToChars = sb.toString().toCharArray();
        Arrays.sort(resultToChars);

        return new String(resultToChars);
    }

    private static boolean isNotContains(Set<Integer> checkedIndexes, int i) {
        return !checkedIndexes.contains(i);
    }
}
