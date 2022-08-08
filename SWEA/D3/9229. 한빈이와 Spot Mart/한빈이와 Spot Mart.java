import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static int n, limit, max = Integer.MIN_VALUE;
    static int[] snacks;
    static boolean[] visited;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            limit = sc.nextInt();

            snacks = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                snacks[i] = sc.nextInt();
            }

            findWay(0, 0);
            System.out.printf("#%d %d\n", t, max == Integer.MIN_VALUE ? -1 : max);
            max = Integer.MIN_VALUE; // 최댓값 초기화
        }
    }

    static void findWay(int cnt, int sum) {
        if (sum > limit) return;

        if (cnt == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findWay(cnt + 1, sum + snacks[i]);
                visited[i] = false;
            }
        }

    }
}
