import java.io.*;
import java.util.*;

public class Main {
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0,-1}, {0,0}, {0,1}, {1,-1}, {1,0}, {1, 1}};
    static boolean[][] check;
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            map = new int[m][n];
            check = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        dfs(new int[] {i, j});
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int[] start) {
        int x = start[0];
        int y = start[1];
        check[x][y] = true;

        for (int i = 0; i < 9; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (map[nx][ny] == 0) continue;
            if (check[nx][ny]) continue;
            dfs(new int[] {nx, ny});
        }
    }
}