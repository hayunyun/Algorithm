import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int n, m, ans;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken()); // 집이 지불하는 비용
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 매 좌표마다, 손해가 될때까지 k 키워나가며
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    service(i, j);
                }
            }
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static void service(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        for (int k = 1; k <= n + 1; k++) {
            boolean[][] vis = new boolean[n][n];
            int house = 0;
            q.add(new Node(r, c, 1));
            vis[r][c] = true;
            if (map[r][c] == 1) house++;
            while (!q.isEmpty()) {
                Node now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (!vis[nr][nc] && now.cnt < k) {
                            q.add(new Node(nr, nc, now.cnt + 1));
                            vis[nr][nc] = true;
                            if (map[nr][nc] == 1) house++;
                        }
                    }
                }
            }

            int service = k * k + (k - 1) * (k - 1);

            if (house * m - service  >= 0) {
                ans = Math.max(ans, house);
            }
        }
    }
}
