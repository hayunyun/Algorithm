import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int row, col, k, ans;
    static char[][] map;
    static boolean[][] vis;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        vis[row-1][0] = true;
        findWay(row - 1, 0, 1);
        System.out.println(ans);
    }

    static void findWay(int r, int c, int cnt) {
        if (r == 0 && c == col - 1) {
            if (cnt == k) {
                ans++;
                return;
            }
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                if (map[nr][nc] == '.' && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    findWay(nr, nc, cnt + 1);
                    vis[nr][nc] = false;
                }
            }
        }
    }
}
