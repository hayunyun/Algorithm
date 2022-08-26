import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    주사위는 윗면이 1이고 동쪽이 3인 방향으로 놓여져 있음
    각 칸에는 정수가 있고
    1. 칸이 0일경우) 주사위에 바닥면의 수 -> 칸으로 복사됨
    2. 0이 아닐경우) 칸의 수 -> 주사위 바닥면에 복사, 칸은 0이 됨

    주사위가 이동했을 때마다 상단에 쓰여있는 값을 구하는 프로그램 작성

     */
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1}; // 동서북남
    static int[] dc = {1, -1, 0, 0};
    static int[] dice = new int[6];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 지도 가로
        m = Integer.parseInt(st.nextToken()); // 지도 세로
        x = Integer.parseInt(st.nextToken()); // 주사위 x좌표
        y = Integer.parseInt(st.nextToken()); // 주사위 y좌표
        k = Integer.parseInt(st.nextToken()); // 명령의 개수

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            roll(Integer.parseInt(st.nextToken()) - 1);
        }

        System.out.println(sb);
    }

    /*
    주사위 이동 명령에 따라 주사위 이동
    이동칸이 0 이면 주사위 바닥면 숫자 바닥에 복사
    0이 아니면 주사위 바닥면에 숫자 복사
    이동시마다 주사위 상단 값 출력
     */

    static void roll(int dir) {
        int nr = x + dr[dir];
        int nc = y + dc[dir];

        if (check(nr, nc)) {
            int top = dice[0];
            // 주사위 굴릴 때마다 주사위 바닥면 구하기
            // 이동한 방향면이 바닥면이 됨
            switch (dir) {
                case 0: // 동
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = dice[2];
                    dice[2] = top;
                    break;
                case 1: // 서
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = top;
                    break;
                case 2: // 남
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = top;
                    break;
                case 3: // 북
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = top;
                    break;
            }

            // 상단면 출력
            sb.append(dice[0]).append("\n");

            // 칸이 0이면 주사위 바닥면 숫자가 맵에 복사
            if (map[nr][nc] == 0) {
                map[nr][nc] = dice[5];
            }
            // 0이 아니면 주사위에 맵 숫자 복사
            else {
                dice[5] = map[nr][nc];
                map[nr][nc] = 0;
            }

            x = nr;
            y = nc;
        }
    }

    static boolean check(int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < m) {
            return true;
        }
        return false;
    }
}
