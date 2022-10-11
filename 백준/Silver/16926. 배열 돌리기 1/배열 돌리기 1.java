import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // r번 회전

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        turn(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 반시계 방향 회전 -> 시계방향으로 구현
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    private static void turn(int round) {
        int cnt = Math.min(m, n) / 2;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < cnt; j++) {
                int dir = 0;
                int r = j, c = j;
                int tmp = map[r][c];
                while (dir < 4) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr >= j && nr < n - j && nc >= j && nc < m - j) {
                        map[r][c] = map[nr][nc];
                        r = nr;
                        c = nc;
                    } else {
                        dir++;
                    }
                }
                map[r+1][c] = tmp;
            }
        }
    }
}
