import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] map;
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tetromino(i, j);
            }
        }

        System.out.println(ans);
    }

    /*
    각 모양 하나씩 돌면서
    가능할 경우 다 대보면서 계산하고, 최댓값 비교 및 갱신
     */

    static void tetromino(int r, int c) {
        one(r, c);
        two(r, c);
        threeFive(r, c);
        four(r, c);
    }

    static void one(int r, int c) {
        // 1-1. 가로
        int sum = 0;
        int nc = c + 3;
        if (nc < m) {
            for (int i = c; i <= nc; i++) {
                sum += map[r][i];
            }
        }
        ans = Math.max(ans, sum);

        // 1-2. 세로
        sum = 0;
        int nr = r + 3;
        if (nr < n) {
            for (int i = r; i <= nr; i++) {
                sum += map[i][c];
            }
        }
        ans = Math.max(ans, sum);
    }

    static void two(int r, int c) {
        int sum = 0;
        if (r + 1 < n && c + 1 < m) {
            for (int i = r; i <= r + 1; i++) {
                for (int j = c; j <= c + 1; j++) {
                    sum += map[i][j];
                }
            }
        }
        ans = Math.max(ans, sum);
    }

    static void threeFive(int r, int c) {
        // 3-1. 원래 모형
        int nr = r + 2;
        int nc = c + 1;
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        if (nr < n && nc < m) {
            for (int i = r; i <= nr; i++) {
                sum += map[i][c];
                sum3 += map[i][nc];
            }
            sum3 += map[nr][c];
            sum2 = sum + map[r + 1][nc];
            sum += map[nr][nc];
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);
        ans = Math.max(ans, sum3);

        // 3-2. 시계방향 90도
        nr = r + 1;
        nc = c + 2;
        sum = 0;
        sum3 = map[r][c];
        if (nr < n && nc < m) {
            for (int i = c; i <= nc; i++) {
                sum += map[r][i];
                sum3 += map[nr][i];
            }
            sum2 = sum + map[nr][c + 1];
            sum += map[nr][c];
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);
        ans = Math.max(ans, sum3);

        // 3-3. 시계방향 180도
        nr = r + 2;
        nc = c + 1;
        sum = 0;
        sum3 = 0;
        if (nr < n && nc < m) {
            for (int i = r; i <= nr; i++) {
                sum += map[i][nc];
                sum3 += map[i][c];
            }
            sum3 += map[r][nc];
            sum2 = sum + map[r + 1][c];
            sum += map[r][c];
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);
        ans = Math.max(ans, sum3);

        // 3-4. 시계방향 270도
        nr = r - 1;
        nc = c + 2;
        sum = 0;
        if (nr >= 0 && nc < m) {
            for (int i = c; i <= nc; i++) {
                sum += map[r][i];
            }
            if (r + 1 < n) sum3 = sum + map[r + 1][nc];
            sum2 = sum + map[nr][c + 1];
            sum += map[nr][nc];
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);
        ans = Math.max(ans, sum3);
    }

    static void four(int r, int c) {
        // 4-1. 원래 모형
        int nr = r + 2;
        int nc = c + 1;
        int sum = 0;
        int sum2 = 0;
        if (nr < n) {
            if (nc < m) {
                for (int i = r; i < nr; i++) {
                    sum += map[i][c];
                }
                for (int i = nr - 1; i <= nr; i++) {
                    sum += map[i][nc];
                }
            }
            nc = c - 1;
            if (nc >= 0) {
                for (int i = r; i < nr; i++) {
                    sum2 += map[i][c];
                }
                for (int i = nr - 1; i <= nr; i++) {
                    sum2 += map[i][nc];
                }
            }
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);

        // 4-2. 시계방향 90도
        nr = r - 1;
        nc = c + 2;
        sum = 0;
        sum2 = 0;
        if (nc < m) {
            if (nr >= 0) {
                for (int i = c; i < nc; i++) {
                    sum += map[r][i];
                }
                for (int i = nc - 1; i <= nc; i++) {
                    sum += map[nr][i];
                }
            }
            nr = r + 1;
            if (nr < n) {
                for (int i = c; i < nc; i++) {
                    sum2 += map[r][i];
                }
                for (int i = nc - 1; i <= nc; i++) {
                    sum2 += map[nr][i];
                }
            }
        }
        ans = Math.max(ans, sum);
        ans = Math.max(ans, sum2);
    }
}
