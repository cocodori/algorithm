package sw;

import java.util.Scanner;

public class 유효숫자표기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String n = sc.next();
            boolean compare = Integer.parseInt(n.charAt(2) + "") >= 5;

            String[] split = n.split("");
            split[1] = compare ? (Integer.valueOf(split[1]) + 1) + "" : split[1];
            String result = split[0] + "." + split[1];
            int power = n.length() - 1;

            if (result.equals("9.10")) {
                result = "1.0";
                power = n.length();
            }

            System.out.println("#"+t+" "+result+"*10^"+power);
        }
    }
}
