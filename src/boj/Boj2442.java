package boj;

import java.util.Scanner;

public class Boj2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;
        String star = "*";

        for (int i = 0; i < n; i++) {
            for (int j = k--; j > 1; j--) {
                System.out.print(" ");
            }
            System.out.print(star + "\n");
            star += "**";
        }
    }
}