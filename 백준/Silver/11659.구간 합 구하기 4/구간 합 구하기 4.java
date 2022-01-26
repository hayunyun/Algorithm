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
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        int[] nums = new int [n+1];
        int[] dp = new int [n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken()); 
        }
        
        // 점화식을 이용한 계산 : 현재값+여기까지의 누적합
        for (int j = 1; j <= n; j++) {
            dp[j] += nums[j] + dp[j-1];
        }

        // x ~ y의 부분합 : y의 누적합 - (x-1)의 누적합
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 
            int ans = dp[y] - dp[x-1];
            bw.write(ans+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}