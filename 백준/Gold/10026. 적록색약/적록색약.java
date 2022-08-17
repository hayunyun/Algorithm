import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] vis;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int cnt = 0, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 적록색약 x
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) bfs(i, j);
            }
        }
        sb.append(cnt).append(" ");

        // 초기화
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }

        // 적록색약
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) bfsRG(i, j);
            }
        }
        sb.append(cnt);

        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        char color = map[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc] && map[nr][nc] == color) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }

        cnt++;
    }

    static void bfsRG(int r, int c) {
        char color = map[r][c];
        boolean flag = (color == 'B'); // B면 true, RG면 false
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc]) {
                        if ((flag && map[nr][nc] == color) || (!flag && map[nr][nc] != 'B') ) {
                            q.add(new int[] {nr, nc});
                            vis[nr][nc] = true;
                        }
                    }
                }
            }
        }

        cnt++;
    }
}
