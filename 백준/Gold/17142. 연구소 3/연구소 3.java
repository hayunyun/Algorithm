import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] map, sel;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static ArrayList<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        sel = new int[m][2];

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new int[] {i, j});
                    map[i][j] = -2;
                }
                else if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
                else if (map[i][j] == 0 && !flag) {
                    flag = true;
                }
            }
        }

        if (flag) {
            ans = Integer.MAX_VALUE;
            place(0, 0);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        } else {
            System.out.println(0);
        }
    }

    // 바이러스 조합
    static void place(int idx, int cnt) {
        if (cnt == m) {
            // 바이러스 퍼트려보고 최솟값 갱신
            // 맵은 깊은 복사 해서 사용
            int[][] newMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newMap[i][j] = map[i][j];
                }
            }

            boolean[][] vis = new boolean[n][n];
            Queue<int[]> v = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int r = sel[i][0];
                int c = sel[i][1];

                newMap[r][c] = 0;
                vis[r][c] = true;
                v.add(new int[] {r, c});
            }

            virus(newMap, v, vis);
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            sel[cnt] = virus.get(i);
            place(i + 1, cnt + 1);
        }
    }

    
    static void virus(int[][] m, Queue<int[]> v, boolean[][] vis) {
        while (!v.isEmpty()) {
            int[] now = v.poll();
            int r = now[0]; int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc] && (m[nr][nc] == 0 || m[nr][nc] == -2)) {
                        m[nr][nc] = m[r][c] + 1;
                        v.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0 && !vis[i][j]) return;
                int[] vv = virus.get(idx);
                if (vv[0] == i && vv[1] == j) {
                	if (idx < virus.size() - 1) {
                		idx++;
                	}
                	continue;
                }

                max = Math.max(max, m[i][j]);
            }
        }

        ans = Math.min(max, ans);
    }
}
