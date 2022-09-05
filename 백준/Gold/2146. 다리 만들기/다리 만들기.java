import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    1. 섬 파악하기 (현재 섬과 다른 섬을 연결해야 함 -> 111 222 333 으로 구분하자)
    2. 섬 사이에 다리 다 놔보면서 최소거리 구하기 (1 기준으로 2, 3, 4, && 2 기준으로 3, 4 , ...)

     */
    static class Bridge {
        int r, c, dist;

        public Bridge(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static int n, islands, minBridge;
    static int[][] map;
    static boolean[][] vis;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 파악하고 카운팅하기
        islands = 1;
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && map[i][j] == 1) {
                    findIsland(i, j);
                }
            }
        }

        // 섬 사이에 다리 다 놔보면서 최소거리 구하기
        minBridge = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    bridgeTest(i, j);
                }
            }
        }

        System.out.println(minBridge);
    }

    static void bridgeTest(int r, int c) {
        vis = new boolean[n][n];

        Queue<Bridge> q = new LinkedList<>();
        q.add(new Bridge(r, c, 0));
        vis[r][c] = true;

        while (!q.isEmpty()) {
            Bridge now = q.poll();
            int row = now.r;
            int col = now.c;
            int dist = now.dist;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc]) {
                        if (map[nr][nc] == 0) {
                            q.add(new Bridge(nr, nc, dist + 1));
                            vis[nr][nc] = true;
                        }
                        else if (map[nr][nc] > map[r][c]) {
                            minBridge = Math.min(minBridge, dist);
                            return;
                        }
                    }
                }
            }

        }
    }

    static void findIsland(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;
        map[r][c] = islands;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc] && map[nr][nc] == 1) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;
                        map[nr][nc] = islands;
                    }
                }
            }

        }

        islands++;
    }
}
