import java.io.*;

public class Main {
    static int[][] dp;
    static int T;
    static int[] stair;

    static void pro () {
        // 초기값 구하기
        dp[1][0] = stair[1];
        dp[2][0] = stair[2];
        dp[2][1] = stair[1] + stair[2];

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 3; i <= T; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
            dp[i][1] = dp[i-1][0] + stair[i];
        }

        // Dy배열로 정답 계산
        System.out.println(Math.max(dp[T][0], dp[T][1]));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        stair = new int[T+1];
        dp = new int[T+1][2];
        for (int i = 1; i <= T; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        if (T==1) System.out.println(stair[1]);
        else pro();
    }
}
