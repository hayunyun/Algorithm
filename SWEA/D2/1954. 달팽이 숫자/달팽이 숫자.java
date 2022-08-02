import java.util.Scanner;

public class Solution {
    static int[][] map;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();

            map = new int[n][n];
            loop(0, n, 1);

            // Output
            System.out.printf("#%d\n", test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static void loop(int start, int end, int val) {
        if (val == n * n + 1) return;
        if (start == end) {
            map[start][start] = val;
            return;
        }

        // 우측으로 이동하며 값 증가
        for (int i = start; i < end; i++) {
            map[start][i] = val++;
        }

        // 우측으로 내려가며 값 증가
        for (int i = start + 1; i < end; i++) {
            map[i][end - 1] = val++;
        }

        // 좌측으로 이동하며 값 증가
        for (int i = end - 2; i >= start; i--) {
            map[end - 1][i] = val++;
        }

        // 상단으로 올라가며 값 증가
        for (int i = end - 2; i > start; i--) {
            map[i][start] = val++;
        }

        // 시작값++, 종료값-- 후 내부 사각형 재귀
        loop(start + 1, end - 1, val);
    }

}