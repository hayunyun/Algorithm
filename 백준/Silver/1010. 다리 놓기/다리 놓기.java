import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[31][31];

        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                if (dp[i][j] != 0) continue; // 이미 값이 기록되어 있으면 넘어간다

                if (i == j) dp[i][j] = 1; // nCk 에서 n==k일 경우 값은 1이다
                else if (j == 1) dp[i][j] = i; // nCk 에서 k==1일 경우 값은 n이다
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);
    }
}
