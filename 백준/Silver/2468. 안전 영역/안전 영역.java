import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] vis;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] == i) {
                        map[j][k] = -1;
                    }
                }
            }

            // 덩이 세기
            int cnt = 0;
            vis = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!vis[j][k] && map[j][k] != -1) {
                        cnt++;
                        bfs(j, k);
                    }
                }
            }

            max = Math.max(max, cnt);
            if (cnt == 0) break;
        }
        System.out.println(max);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc] && map[nr][nc] != -1) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }
    }
}
