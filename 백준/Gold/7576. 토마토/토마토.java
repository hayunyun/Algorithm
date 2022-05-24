import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {1, -1, 0, 0}; // 상하
    static int[][] map;
    static int n, m, cnt;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.add(new int[] {i, j});
            }
        }

        bfs();
        check();
    }

    static void check() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                else if (map[i][j] > max) max = map[i][j];
            }
        }
        System.out.println(max - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (map[nextX][nextY] == 0) {
                        q.add(new int[] {nextX, nextY});
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}