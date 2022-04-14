import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (map[nr][nc] == 0) continue;
                if (visited[nr][nc]) continue;

                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}