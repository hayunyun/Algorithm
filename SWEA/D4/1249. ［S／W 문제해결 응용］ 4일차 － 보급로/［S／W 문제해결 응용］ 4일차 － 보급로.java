import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int n;
    static int[][] map;
    static int[][] times;
    static boolean[][] vis;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};

    static class Info implements Comparable<Info> {
        int r, c, time;

        public Info(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            vis = new boolean[n][n];
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            times = new int[n][n];
            djikstra();
            sb.append("#").append(tc).append(" ").append(times[n-1][n-1]).append("\n");
        }
        System.out.println(sb);
    }

    static void djikstra() {
        // 다 무한으로 채운 후, 시작구역만 0
        for (int i = 0; i < n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, 0));
        times[0][0] = 0;

        while (!pq.isEmpty()) {
            Info now = pq.poll();
            int r = now.r;
            int c = now.c;

            if (times[r][c] < now.time) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                    if(times[r][c] + map[nr][nc] < times[nr][nc]) {
                        times[nr][nc] = times[r][c] + map[nr][nc];
                        vis[nr][nc] = true;
                        pq.add(new Info(nr, nc, times[nr][nc]));
                    }
                }
            }
        }
    }
}