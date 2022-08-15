import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        dfs(0, 1, 0);

        System.out.println(ans);

    }

    static void dfs(int r, int c, int pos) {
        if (r == n - 1 && c == n - 1) {
            ans++;
            return;
        }

        switch (pos) {
            case 0: // 가로 - 우
                if (c + 1 < n && map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }
                break;
            case 1: // 세로 - 하
                if (r + 1 < n && map[r + 1][c] == 0) {
                    dfs(r + 1, c, 1);
                }
                break;
            case 2: // 대각선 - 우, 하
                if (c + 1 < n && map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }

                if (r + 1 < n && map[r + 1][c] == 0) {
                    dfs(r + 1, c, 1);
                }
                break;
        }

        // 공통 - 대각선
        if (r + 1 < n && c + 1 < n && map[r][c + 1] == 0 && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0) {
            dfs(r + 1, c + 1, 2);
        }
    }
}
