import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n, k, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> nemos = new ArrayList<>();
    static boolean[][] map, vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[m][n];
        vis = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = m - Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = m - Integer.parseInt(st.nextToken());
            nemo(d, c, b, a);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && !map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(ans).append("\n");
        Collections.sort(nemos);
        for (int ne : nemos) {
            sb.append(ne + " ");
        }
        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;
        int total = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 & nr < m && nc >= 0 && nc < n) {
                    if (!vis[nr][nc] && !map[nr][nc]) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                        total++;
                    }
                }
            }
        }

        ans++;
        nemos.add(total);
    }

    static void nemo(int startR, int startC, int endR, int endC) {
        for (int i = startR; i < endR; i++) {
            for (int j = endC; j < startC; j++) {
                if (!map[i][j]) {
                    map[i][j] = true;
                }
            }
        }
    }
}
