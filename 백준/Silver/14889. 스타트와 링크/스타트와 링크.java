import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = Integer.MAX_VALUE;
    static int[] sel;
    static boolean[] check;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTrack(0, 0);
        System.out.println(ans);
    }

    // 조합
    static void backTrack(int idx, int cnt) {
        if (cnt == n / 2) {
            int sumA = 0, sumB = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (check[i] && check[j]) {
                        sumA += map[i][j];
                        sumA += map[j][i];
                    } else if (!check[i] && !check[j]) {
                        sumB += map[i][j];
                        sumB += map[j][i];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(sumA - sumB));
            return;
        }

        for (int i = idx; i < n; i++) {
            check[i] = true;
            backTrack(i + 1, cnt + 1);
            check[i] = false;
        }
    }
}
