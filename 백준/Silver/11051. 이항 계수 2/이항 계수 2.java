import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        dp = new int[n+1][r+1];

        System.out.println(binomial(n, r));
    }

    static int binomial(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];

        if (r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = (binomial(n-1, r-1) + binomial(n-1, r)) % 10007;
    }
}
