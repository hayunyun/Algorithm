import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] check;
    static char[][] map;
    static int n, m, s, w;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int sheep = 0; int wolf = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && (map[i][j] == 'o' || map[i][j] == 'v')) {
                    s = w = 0;
                    dfs(i, j);
                    if (s > w) sheep += s;
                    else wolf += w;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int x, int y) {
        check[x][y] = true;

        if (map[x][y] == 'o') s += 1;
        else if (map[x][y] == 'v') w += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (check[nx][ny] || map[nx][ny] == '#') continue;

            dfs(nx, ny);
        }
    }
}