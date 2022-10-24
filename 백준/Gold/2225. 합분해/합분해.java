import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1]; // 정수 k개를 더해서 합이 n인 경우
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1; // 숫자 1개로 n을 만드는 경우의 수는 모두 1
        }

        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1; // 숫자 i개로 0을 만드는 경우의 수는 모두 1 (0+0+...+0)
        }

        // dp[0][j-1] + ... + dp[i-1][j]
        // -> dp[i-1][j] + dp[i][j-1]
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD; 
            }
        }

        System.out.println(dp[k][n]);
    }
}
