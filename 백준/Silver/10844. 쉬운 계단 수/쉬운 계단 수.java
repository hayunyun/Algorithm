import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][n+1];

        // 자릿수가 하나일땐 1~9가 1개씩 있음
        for (int i = 1; i < 10; i++) {
            dp[i][1] = 1;
        }

        // 두번째 자릿수부터 탐색
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                // 0, 9는 각각 1, 8 다음에만 올 수 있음 && 나머지는 이전의 왼쪽 오른쪽값 합
                if (j == 0) {
                    dp[0][i] = dp[1][i-1] % MOD;
                } else if (j == 9) {
                    dp[9][i] = dp[8][i-1] % MOD;
                } else {
                    dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[i][n];
        }
        System.out.println(ans % MOD);
    }
}
