import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        dp = new int[n+1];
        dp[1] = nums[1];
        if (n > 1) {
            dp[2] = nums[1] + nums[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + nums[i], dp[i-3] + nums[i-1] + nums[i])); // 이전 기록값, 비연속, 연속
        }
        
        System.out.println(dp[n]);
    }
}
