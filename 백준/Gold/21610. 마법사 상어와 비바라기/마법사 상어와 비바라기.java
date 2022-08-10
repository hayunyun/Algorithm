import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static boolean[][] visited; // 방문체크 && 구름 위치 표시

    // 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int n, m, lx, ly, rx, ry;
    public static void main(String[] args) throws IOException {
        /*
        n 아래에는 1, 1 위에는 n과 같은 식으로 연결되어 있다
        비바라기를 시전하면
        (n-1,1), (n-1,2)
        (n,1), (n,2)
        이렇게 비구름이 생긴다

        비구름은 d방향으로 s칸 이동한다 (8방탐색)
        이동 후 구름이 있는 칸에 물의 양 1 증가
        물이 증가한 칸에 물복사버그 -> 대각선 방향으로 거리가 1인 칸에 물이 0이 아닌 바구니의 수만큼 해당칸 물 양 증가
        (경계 넘어가면 취급안해줌)

        구름이 있었던 칸 제외, 물의 양이 2 이상일 경우 구름이 생기고, 물의 양이 2 줄어듦.

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 방향
            int s = Integer.parseInt(st.nextToken()); // 이동거리

            shark(i, d, s);
        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += A[i][j];
            }
        }
        System.out.println(sum);
    }

    static void shark(int idx, int d, int s) {
        // 1-1. 초기 - (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 구름 생성
        if (idx == 0) {
            lx = n - 2; ly = 0;
            rx = n - 1; ry = 1;

            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    visited[i][j] = true;
                }
            }
        }
        // 1-2. 초기가 아니라면, visited에 체크된 것들이 구름.

        // 2. 모든 구름이 d 방향으로 s칸 이동
        boolean[][] flags = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    int r = i; int c = j;
                    for (int k = 0; k < s; k++) {
                        r += dr[d];
                        if (r < 0) r += n;
                        else if (r >= n) r -= n;

                        c += dc[d];
                        if (c < 0) c += n;
                        else if (c >= n) c -= n;
                    }
                    flags[r][c] = true;
                }
            }
        }
        visited = flags;

        // 3. 구름이 있는 바구니의 물양++
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    A[i][j] += 1;
                }
            }
        }

        // 4. 한칸씩 대각선에 물이 있는지 확인 후 물이 있는 수만큼 물양 증가
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    A[i][j] += checkCross(i, j);
                }
            }
        }

        // 5. 구름이 생성된 칸 제외, 물의 양이 2 이상인 모든 칸에 구름 생김
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && A[i][j] >= 2) {
                    A[i][j] -= 2;
                    visited[i][j] = true; // 구름 위치 표시
                }
                else if (visited[i][j]) {
                    visited[i][j] = false;
                }
            }
        }

        // 6. 생성된 구름으로 다시 1~5 반복
    }

    static int checkCross(int r, int c) {
        int cnt = 0;

        // 대각선 체크 - 좌상 좌하 우상 우하
        int[] checkR = {-1, 1, -1, 1};
        int[] checkC = {-1, -1, 1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + checkR[i];
            int nc = c + checkC[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (A[nr][nc] > 0) cnt++;
            }
        }

        return cnt;
    }
}
