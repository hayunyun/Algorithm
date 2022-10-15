import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, ans, startR, startC;
    static int[] dessert;
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MIN_VALUE;
            dessert = new int[101];
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n-1; j++) {
                    startR = i;
                    startC = j;

                    dessert[map[i][j]]++;
                    search(i, j, 1, 0);
                    dessert[map[i][j]]--;
                }
            }
            sb.append("#" + tc + " " + (ans == Integer.MIN_VALUE ? -1 : ans) + "\n");
        }

        System.out.println(sb);
    }

    static void search(int r, int c, int cnt, int dir) {
        for (int i = dir; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr == startR && nc == startC && cnt >= 4) {
                ans = Math.max(ans, cnt);
                return;
            }

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (dessert[map[nr][nc]] == 0) {
                    dessert[map[nr][nc]]++;

                    search(nr, nc, cnt + 1, i);

                    dessert[map[nr][nc]]--;
                }
            }
        }
    }
}
