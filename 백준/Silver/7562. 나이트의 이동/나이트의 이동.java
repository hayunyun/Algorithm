import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 상좌 상우 하좌 하우 좌상 좌하 우상 우하
    static int[] dr = {-2, -2, 2, 2, -1, 1, -1, 1};
    static int[] dc = {-1, 1, -1, 1, -2, -2, 2, 2};
    static int[][] map;
    static int destR, destC, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destR = Integer.parseInt(st.nextToken());
            destC = Integer.parseInt(st.nextToken());

            if (r == destR && c == destC) {
                sb.append(0);
            } else {
                bfs(r, c);
                sb.append(map[destR][destC]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int i, int j) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(i, j));

        while (!q.isEmpty()) {
            Info now = q.poll();
            int r = now.r;
            int c = now.c;

            if (r == destR && c == destC) return;

            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = map[r][c] + 1;
                        q.add(new Info(nr, nc));
                    }
                }
            }
        }
    }
}
