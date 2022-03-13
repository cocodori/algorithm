import java.util.Scanner;

public class 교환학생 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();

        for (int t = 1; t <= TC; t++) {
            int days = sc.nextInt();
            int[] schedulesOfWeek = new int[7];

            //일정표를 배열에 모두 넣음
            for (int i = 0; i < schedulesOfWeek.length; i++)
                schedulesOfWeek[i] = sc.nextInt();

            //반복한 횟수 = 일수
            //총 더해진 수가 days와 같아지면 return
            int dayCount = 0;
            int sum = 0;

            while (days != sum) {
                for (int schedule : schedulesOfWeek) {
                    if (sum == days) break;
                    sum += schedule;
                    dayCount++;
                }
            }

            System.out.printf("#%d %d\n", t, dayCount);
        }
    }
}
