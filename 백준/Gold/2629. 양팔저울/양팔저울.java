import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] chus;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        chus = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            chus[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n+1][40001];
        knapsack(0, 0);

        int marble = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < marble; i++) {
            int m = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (int c = 0; c <= n; c++) {
                if (dp[c][m]) {
                    flag = true;
                    break;
                }
            }
            sb.append(flag ? "Y" : "N");
            sb.append(" ");
        }

        System.out.println(sb);
    }

    // 추를 저울에 올릴 것인지, 구슬 쪽 저울에 올릴 것인지, 올리지 않을 것인지 냅색
    // dp[x][y] : x번까지의 추를 사용했을 때 y 무게를 만들수 있는지에 대한 여부
    static void knapsack(int cnt, int weight) {
        if (weight > 40000) return;
        if (dp[cnt][weight]) return;

        dp[cnt][weight] = true;
        
        if (cnt == n) return;

        knapsack(cnt+1, weight); // 추를 올리지 않는다
        knapsack(cnt+1, weight + chus[cnt]); // 추를 올린다
        knapsack(cnt+1, Math.abs(weight - chus[cnt])); // 추를 반대쪽에 올린다 (추의 총 무게를 줄인다)
    }
}
