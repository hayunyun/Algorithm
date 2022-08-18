import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] vis = new boolean[26];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r, c, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        ans = Integer.MIN_VALUE;
        check(0, 0, 0);
        System.out.println(ans);
    }

    static void check(int row, int col, int cnt) {
        int now = map[row][col];
        if(vis[now]) {
            ans = Math.max(ans, cnt);
            return;
        }

        vis[now] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                check(nr, nc, cnt + 1);
            }
        }
        vis[now] = false;

    }
}
