import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] pos = new int[11][11];
    static int[] finalPos = new int[11];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            ans = Integer.MIN_VALUE;
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    pos[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            backTrack(0, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void backTrack(int cnt, int sum) {
        if (cnt == 11) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (pos[cnt][i] > 0 && finalPos[i] == 0) {
                finalPos[i] = pos[cnt][i];
                backTrack(cnt + 1, sum + finalPos[i]);
                finalPos[i] = 0;
            }
        }
    }
}
