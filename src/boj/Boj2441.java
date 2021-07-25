package boj;

import java.util.Scanner;

public class Boj2441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String space = "";

        for (int i  = n; i > 0; i--) {
            System.out.print(space);
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println("");
            space += " ";
        }
    }
}
