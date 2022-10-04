import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n];
        int[][] dp = new int[2][301]; // 0: 연속X, 1: 연속O

        for (int i = 0; i < n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = steps[0];

        if (n > 1) {
            dp[0][1] = steps[1];
            dp[1][1] = steps[0] + steps[1];

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) + steps[i];
                dp[1][i] = dp[0][i-1] + steps[i];
            }
        }

        System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

    }
}