import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] stickers;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = calMax();
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int calMax() {
        int[][] scores = new int[2][n];
        scores[0][0] = stickers[0][0];
        scores[1][0] = stickers[1][0];

        if (n==1) return Math.max(scores[0][0], scores[1][0]);

        scores[0][1] = scores[1][0] + stickers[0][1];
        scores[1][1] = scores[0][0] + stickers[1][1];

        if (n==2) return Math.max(scores[0][1], scores[1][1]);

        for (int i = 2; i < n; i++) {
            scores[0][i] = Math.max(scores[1][i-1], scores[1][i-2]) + stickers[0][i];
            scores[1][i] = Math.max(scores[0][i-1], scores[0][i-2]) + stickers[1][i];
        }
        
        return Math.max(scores[0][n-1], scores[1][n-1]);
    }
}
