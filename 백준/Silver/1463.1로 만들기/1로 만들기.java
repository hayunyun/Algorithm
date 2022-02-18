import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer [N+1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
        br.close();
    }

    static int recur (int x) {
        if (dp[x] == null) {
            // 6로 나눠지는 경우 -> 3, 2, -1 중 최소연산
            if (x % 6 == 0)
                dp[x] = Math.min(recur(x - 1), Math.min(recur(x / 3), recur(x / 2))) + 1;
            // 3으로 나눠지는 경우 -> 3으로 나누기, -1
            else if (x % 3 == 0)
                dp[x] = Math.min(recur(x / 3), recur(x - 1)) + 1;
            // 2로 나눠지는 경우 -> 2로 나누기, -1
            else if (x % 2 == 0)
                dp[x] = Math.min(recur(x / 2), recur(x - 1)) + 1;
            // 아무것도 해당 안할때 -> -1
            else
                dp[x] = recur(x - 1) + 1;
        }
        return dp[x];
    }
}
