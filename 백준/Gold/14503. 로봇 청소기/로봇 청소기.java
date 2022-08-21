import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = 0;
    static int[][] map;
    static boolean[][] cleaned;
    static int[] dr = {-1, 0, 1, 0}; // 북동남서
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cleaned = new boolean[n][m];

        // 청소기 정보
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 청소기 방향 - 북동남서


        // 맵 input - 빈칸은 0, 벽은 1
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vacuum(r, c, d);
        System.out.println(ans);

    }

    static void vacuum(int row, int col, int dir) {
        /*
        1. 현재 위치 청소
        2. 현재 위치에서 현재 방향 기준으로 왼쪽부터 차례대로 탐색 진행
            2-1. 왼쪽에 아직 청소하지 않은 공간이 있다면, 그 방향으로 회전(-1) 후 1칸 전진 -> 1번부터 다시
            2-2. 왼쪽에 청소할 공간이 없다면, 그 방향으로 회전 -> 2번부터 다시
            2-3. 네 방향 모두 청소가 되어있거나 벽이라면, 바라보는 방향을 유지한 채로 한 칸 후진 -> 2번
            2-4. 네 방향 모두 청소가 되어있거나 벽이면서, 뒤쪽도 벽이라면 작동 멈춤
         */

        // 1. 현재 위치 청소
        if (map[row][col] == 0) {
            map[row][col] = 2;
            ans++;
//                System.out.println("clean " + row + ", " + col);
        }


        // 2. 현재 방향 기준 왼쪽부터 탐색
        boolean flag = false;
        int now = dir;
        for (int i = 0; i < 4; i++) {
            int nd = (dir + 3) % 4; // 왼쪽 방향 바라봄
            int nr = row + dr[nd];
            int nc = col + dc[nd];

//                System.out.println(d + " " + nr + " " + nc);

            if (nr > 0 && nr < n && nc > 0 && nc < m) {
                // 2-1. 아직 청소하지 않은 공간이 있고, 벽이 아니라면
                if (map[nr][nc] == 0) {
                    vacuum(nr, nc, nd);
                    flag = true;
                    break; // 1번부터 다시 진행
                }
            }
            // 2-2. 청소할 공간이 없다면 방향만 전환
            dir = (dir + 3) % 4;
        }

        // 2-3. 다 봤는데 할 게 없으면 바라보는 방향을 유지한채 한칸후진 == 북 <-> 남, 동 <->서
        if (!flag) {
            int backD = (now + 2) % 4;
            int backR = row + dr[backD];
            int backC = col + dc[backD];
            if (backR > 0 && backR < n && backC > 0 && backC < m) {
                if (map[backR][backC] != 1) {
                    vacuum(backR, backC, now); // 바라보는 방향은 그대로 유지
                }
            }
        }

    }
}
