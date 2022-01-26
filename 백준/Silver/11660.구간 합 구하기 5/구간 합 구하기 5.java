import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 표의 크기
        int m = Integer.parseInt(st.nextToken()); // 합을 구할 횟수

        int[][] nums = new int [n+1][n+1];
        int[][] dp = new int [n+1][n+1];
        
        // 표 채우기 - 정사각형 n*n
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점화식 - 누적합 구하기
        // dp[i][j] = nums[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = nums[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]; // 본인 + 앞 + 위 - 2번더해진 대각선앞부분
            }
        }

        // 합 구하기 - x1,y1 ~ x2, y2 m번
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = dp[x2][y2] - (dp[x1-1][y2] + dp[x2][y1-1]) + dp[x1-1][y1-1]; // 자기 바로전의 부분합 빼주고 겹치게 2번빠진 부분 한번 더해주기
            bw.write(ans+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}