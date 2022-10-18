import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];

        dp[1][0] = 1; // 양쪽에 사자 없음
        dp[1][1] = 1; // 왼쪽에 사자 있음
        dp[1][2] = 1; // 오른쪽에 사자 있음

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD; // 어느쪽에 사자가 있어도 붙일 수 있음
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // 같은 방향은 못 붙임
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD; // 같은 방향은 못 붙임
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
    }
}
