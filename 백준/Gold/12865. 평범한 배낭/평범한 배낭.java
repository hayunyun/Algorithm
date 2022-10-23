import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            knapsack(w, v, i);
        }

        System.out.println(dp[n][k]);
    }

    private static void knapsack(int w, int v, int cnt) {
        for (int j = 1; j <= k; j++) { // 무게 k까지 감당 가능한 최대 가치가 기록되어 있다.
            if (j < w) {
                dp[cnt][j] = dp[cnt-1][j];
            } else {
                dp[cnt][j] = Math.max(dp[cnt-1][j], dp[cnt-1][j-w] + v);
            }
        }
    }
}
