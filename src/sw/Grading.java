package sw;

import java.util.*;
import java.util.stream.Collectors;

public class Grading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int numberOfSubjects = 3;   // 과목 개수
        int[] scores;
        Student[] students;

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();   // 학생의 수
            int K = sc.nextInt();   // 학점을 알고 싶은 학생 번호
            students = new Student[N];

            for (int i = 0; i < N; i++) {
                scores = new int[numberOfSubjects];

                // 중간, 기말, 과제 점수를 저장
                for (int j = 0; j < numberOfSubjects; j++)
                    scores[j] = sc.nextInt();

                students[i] = new Student(i+1, scores);
            }

            List<Student> sortedStudents = Arrays.stream(students)
                    .sorted((o1, o2) -> o1.totalScore < o2.totalScore ? 1 : -1)
                    .collect(Collectors.toList());


            for (int i = 0; i < sortedStudents.size(); i++) {
                if(sortedStudents.get(i).id == K) {
                    System.out.format("#%d %s\n", t, Student.getGrade(10 * i / N));
                    break;
                }
            }
        }
    }

    private static class Student {
        int id;
        double totalScore;
        private static String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        public Student(int id, int[] scores) {
            double midtermExam = scores[0] * 0.35;
            double finalExams = scores[1] * 0.45;
            double task = scores[2] * 0.20;


            this.id = id;
            this.totalScore = midtermExam + finalExams + task;
        }

        public static String getGrade(int index) {
            return grades[index];
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", totalScore=" + totalScore +
                    ", grades=" + Arrays.toString(grades) +
                    '}';
        }
    }
}