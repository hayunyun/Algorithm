import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    // 좌상 우상
    static int[] dr = {-1, -1};
    static int[] dc = {-1, 1};
    static int[] ans = new int[2];
    static boolean[][] isBlack;
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isBlack = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 1 - 놓을 수 있음
            }
        }

//        print();

        boolean[][] vis = new boolean[n][n];
        black(0, 0, 0, 0, vis);

        vis = new boolean[n][n];
        white(0, 1, 0, 1, vis);

        System.out.println(ans[0] + ans[1]);
    }

    static void black(int r, int c, int cnt, int color, boolean[][] vis){
        ans[color] = Math.max(ans[color], cnt);

        if (c >= n) {
            r++;
            c = (r % 2 == 0) ? 0 : 1;
        }

        if (r == n) return;


        if (!vis[r][c]) {
            if (isAble(r, c, vis)) {
                vis[r][c] = true;
                black(r, c + 2, cnt + 1, color, vis);
                vis[r][c] = false;
            }
        }

        black(r, c + 2, cnt, color, vis);
    }

    static void white(int r, int c, int cnt, int color, boolean[][] vis){
        ans[color] = Math.max(ans[color], cnt);

        if (c >= n) {
            r++;
            c = (r % 2 == 0) ? 1 : 0;
        }

        if (r == n) return;


        if (!vis[r][c]) {
            if (isAble(r, c, vis)) {
                vis[r][c] = true;
                white(r, c + 2, cnt + 1, color, vis);
                vis[r][c] = false;
            }
        }

        white(r, c + 2, cnt, color, vis);
    }

    static boolean isAble(int r, int c, boolean[][] vis) {
        if (map[r][c] == 0) return false;

        // 좌측 하단부터 우측 하단순으로 탐색하므로 윗 대각선의 비숍만 체크한다.
        for (int i = 0; i < 2; i++) {
            int curR = r, curC = c;
            int nr, nc;
            while (true) {
                nr = curR + dr[i];
                nc = curC + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;
                if (vis[nr][nc]) return false;

//                vis[nr][nc] = true;
                curR = nr;
                curC = nc;
            }
        }

        return true;
    }
}
