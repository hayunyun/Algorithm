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

    // 행*열의 개수 나머지만큼 돌리기
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static void turn(int round) {
        int min = Math.min(n, m) / 2;
        for (int i = 0; i < min; i++) {
            int cur = round % ((2*(n+m) - 4) - 8*i); // 한칸씩 안으로 들어갈때마다 가로세로 각각 -2됨 (양변4이므로 총 -8)
            for (int j = 0; j < cur; j++) {
                int r = i, c = i;
                int tmp = map[r][c];
                int dir = 0;
                while (dir < 4) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr >= i && nr < n - i && nc >= i && nc < m - i) {
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
