import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, island;
    static int[][] map;
    static boolean[][] vis;
    static int[][] brdg;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    /*
    1. 섬 구분
    2. 각 섬마다 테두리에 닿을 때까지 상, 하, 좌, 우 한 방향으로만 뻗어 나가며 섬에 닿으면 거리 기록 (현재 섬 숫자보다 큰 것만)
    3. 프림 알고리즘으로 매번 최소거리 갱신
     */
    static class Bridge {
        int r, c, dist, dir;

        public Bridge(int r, int c, int dist, int dir) {
            this.r = r;
            this.c = c;
            this.dist= dist;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 대륙 구분
        island = 1;
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && map[i][j] != 0) cntIsld(i, j);
            }
        }

        // 섬마다 최소 거리의 다리 찾기
        brdg = new int[island][island];
        for (int i = 1; i < island; i++) {
            for (int j = 1; j < island; j++) {
                brdg[i][j] = Integer.MAX_VALUE;
            }
        }

        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && map[i][j] != 0) {
                    buildBrdg(i, j);
                }
            }
        }

        // 프림 알고리즘
        System.out.println(prim(1));
    }


    static int prim(int now) {
        for (int i = 1; i < island; i++) {
            boolean check = true;
            for (int j = 1; j < island; j++) {
                if (brdg[i][j] != Integer.MAX_VALUE) {
                    check = false;
                }
            }

            if (check) return -1;
        }

        boolean[] isldCheck = new boolean[island];
        int[] dist = new int[island];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[now] = 0;

        for (int i = 1; i < island - 1; i++) {
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j < island; j++) {
                if (!isldCheck[j] && dist[j] < minVal) {
                    minIdx = j;
                    minVal = dist[j];
                }
            }

            if (minIdx == -1) {
                return -1;
            }

            isldCheck[minIdx] = true;
            for (int j = 1; j < island; j++) {
                if (!isldCheck[j] && brdg[minIdx][j] < dist[j]) {
                    dist[j] = brdg[minIdx][j];
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i < island; i++) {
            ans += dist[i];
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static void buildBrdg(int r, int c) {
        vis = new boolean[n][m];
        Queue<Bridge> q = new LinkedList<>();
        for (int d = 0; d < 4; d++) {
            q.add(new Bridge(r, c, 0, d));
        }
        vis[r][c] = true;
        int curIsld = map[r][c];

        while (!q.isEmpty()) {
            Bridge b = q.poll();

            int nr = b.r + dr[b.dir];
            int nc = b.c + dc[b.dir];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (!vis[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        q.add(new Bridge(nr, nc, b.dist + 1, b.dir));
                    } else if (map[nr][nc] != curIsld) {
                        int nextIsld = map[nr][nc];
                        if (b.dist == 1) continue;
                        brdg[curIsld][nextIsld] = Math.min(brdg[curIsld][nextIsld], b.dist);
                    }
                }
            }
        }
    }

    static void cntIsld(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;
        map[r][c] = island;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!vis[nr][nc] && map[nr][nc] != 0) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                        map[nr][nc] = island;
                    }
                }
            }
        }

        island++;
    }
}
