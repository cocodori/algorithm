package boj;

import java.util.Scanner;

public class Boj2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String star = "*";

        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print(star+"\n");
            star += "*";
        }
    }
}
