import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, ans;
    static Info[] turns;
    /*
    1. 회전의 순열을 구하며 구하는 대로 회전한다 (반복 연산 줄이고자)
    2. 연산 수 == K가 되면, 최솟값을 갱신한다
     */
    static class Info {
        int r, c, s;

        public Info(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static int[] sel;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis = new boolean[k];
        turns = new Info[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            turns[i] = new Info(r, c, s);
        }

        ans = Integer.MAX_VALUE;
        calc(0, map);
        System.out.println(ans);
    }

    // 순열!!!
    private static void calc(int cnt, int[][] map) {
        if (cnt == k) {
            ans = Math.min(ans, getTotal(map));
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!vis[i]) {
                vis[i] = true;
                int[][] newMap = copyMap(map);
                turn(turns[i], newMap);
                calc(cnt + 1, newMap);
                vis[i] = false;
            }
        }
    }

    // 반시계 -> 하우상좌
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    private static void turn(Info info, int[][] map) {
        /*
        가장 왼쪽 칸이 (r-s, c-s), 오른쪽 칸이 (r+s, c+s)인 정사각형을 시계방향으로 한칸씩 회전
         */
        int r = info.r;
        int c = info.c;
        int s = info.s;

        // 반시계방향으로 구현
        for (int i = 0; i < s; i++) {
            int row = r-s + i;
            int col = c-s + i;
            int dir = 0;
            int tmp = map[row][col];

            while (dir < 4) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                if (nr >= r-s + i && nr <= r + s - i && nc >= c-s + i && nc <= c + s - i) {
                    map[row][col] = map[nr][nc];
                    row = nr;
                    col = nc;
                } else {
                    dir++;
                }
            }
            map[r-s + i][c-s + i+1] = tmp;
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }

    private static int getTotal(int[][] map) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                cur += map[i][j];
            }
            if (cur < min) min = cur;
        }
        return min;
    }
}
