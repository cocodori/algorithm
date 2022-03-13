import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t<=10; t++) {
            int length = sc.nextInt();
            String input = sc.next();
            String[] split = input.split("");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
            while (length-2 >= 0) {
                if (list.get(length-1).equals(list.get(length-2))) {
                    list.remove(length-1);
                    list.remove(length-2);
                    length = list.size();
                    continue;
                }
                length--;
            }
            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);
            System.out.printf("#%d %s\n", t, sb.toString());
        }
    }
}
