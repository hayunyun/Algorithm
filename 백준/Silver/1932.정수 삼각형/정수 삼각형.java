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
        
        int n = Integer.parseInt(br.readLine()); 
        int nums [][] = new int [n+1+1][n+1+1];
        int D [][] = new int [n+1+1][n+1+1];
        int ans = 0;
        StringTokenizer st;

        // input
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        // 점화식을 이용한 계산
        // D[i][j] = nums[i][j] + max(D[i-1][j-1], D[i-1][j]) // 본인 + 왼쪽대각선 저장값 또는 오른쪽대각선 저장값

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = nums[i][j] + Integer.max(D[i-1][j-1], D[i-1][j]);
            }
        }

        // 정답 찾기
        for (int i = 1; i <= n; i++) {
            ans = Integer.max(ans, D[n][i]); // 마지막 줄만 구하면 되니까
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}