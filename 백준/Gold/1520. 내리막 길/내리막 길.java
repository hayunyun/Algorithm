import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp; // 경로의 수 저장
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    // 탑다운 방식 DP!
    static int dfs(int r, int c) {
        if (r == n - 1 && c == m - 1) { // 도착하면 1 return
            return 1;
        }

        if (dp[r][c] != -1) { // 이미 방문한 곳이면 탐색 종료, 이미 기록된 값을 return
            return dp[r][c];
        }

        dp[r][c] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (map[nr][nc] < map[r][c]) {
                    dp[r][c] += dfs(nr, nc);
                }
            }
        }

        return dp[r][c]; // 시작점에 모든 경로의 수가 더해진다
    }
}
