import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, m, cnt = 0, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(cnt > 0 ? max : 0);
    }

    static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        int total = 1;

        int[] dx = {0, 0, -1, 1}; // 좌우
        int[] dy = {-1, 1, 0, 0}; // 상하

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 1) {
                            total++;
                            q.add(new int[] {nx, ny});
                        }
                    }
                }
            }
        }

        return total;
    }
}
