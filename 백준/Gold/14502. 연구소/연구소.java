import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    1. 3개를 백트래킹으로 가능한 영역에 모두 세우고,
    2. 3개 다 세우면 바이러스 다 퍼트려본후
    3. 안전영역 계산해서 최댓값 비교
     */
    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] sel = new int[3][2];
    static int[] dr = {-1, 1, 0, 0,};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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

        pence(0, 0, 0);
        System.out.println(ans);
    }

    static void pence(int r, int c, int cnt) {
        if (cnt == 3) {
            // 바이러스 다 퍼트려보기
            int[][] newMap = new int[n][m];
            Queue<int[]> vs = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newMap[i][j] = map[i][j];
                    if (map[i][j] == 2) {
                        vs.add(new int[] {i, j});
                    }
                }
            }

            virus(newMap, vs);
            return;
        }

        if (r >= n) return;

        if (c >= m) {
            pence(r + 1, 0, cnt);
            return;
        }

        if (map[r][c] == 0) {
            map[r][c] = 1;
            sel[cnt][0] = r;
            sel[cnt][1] = c;
            pence(r, c + 1, cnt + 1);
            map[r][c] = 0;
        }

        pence(r, c + 1, cnt);
    }

    private static void virus(int[][] newMap, Queue<int[]> vs) {
        while (!vs.isEmpty()) {
            int[] now = vs.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (newMap[nr][nc] == 0) {
                        newMap[nr][nc] = 2;
                        vs.add(new int[] {nr, nc});
                    }
                }
            }
        }

        // 안전영역 구하기
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) cnt++;
            }
        }

        ans = Math.max(ans, cnt);
    }
    
}
