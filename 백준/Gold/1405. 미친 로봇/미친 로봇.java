import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double ans;
    static double[] dirs = new double[4];
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] vis = new boolean[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            dirs[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        vis[15][15] = true;
        search(15, 15, 0, 1);
        System.out.println(ans);
    }

    // 단순할 확률을 구하자
    static void search(int r, int c, int cnt, double total) {
        if (cnt == n) {
            ans += total;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 30 && nc >= 0 && nc < 30) {
                if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    search(nr, nc, cnt + 1, total * dirs[i]);
                    vis[nr][nc] = false;
                }
            }
        }
    }
}
