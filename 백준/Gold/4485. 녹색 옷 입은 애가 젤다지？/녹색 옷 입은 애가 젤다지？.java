import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static class Info implements Comparable<Info> {
        int r, c, coin;

        public Info(int r, int c, int coin) {
            this.r = r;
            this.c = c;
            this.coin = coin;
        }

        @Override
        public int compareTo(Info o) {
            return this.coin - o.coin;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n==0) break;
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + idx + ": ");
            dijkstra(0, 0);
            idx++;
        }
        System.out.println(sb);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void dijkstra(int r, int c) {
        int[][] dist = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(r, c, map[r][c]));
        dist[r][c] = map[r][c];
        vis[r][c] = true;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = info.r + dr[i];
                int nc = info.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!vis[nr][nc]) {
                        if (dist[nr][nc] > info.coin + map[nr][nc]) {
                            dist[nr][nc] = info.coin + map[nr][nc];
                            vis[nr][nc] = true;
                            pq.add(new Info(nr, nc, dist[nr][nc]));
                        }
                    }
                }
            }
        }

        sb.append(dist[n-1][n-1]).append("\n");
    }
}
