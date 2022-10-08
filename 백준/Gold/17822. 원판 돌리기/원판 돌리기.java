import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static int[][] circle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 원판의 수
        m = Integer.parseInt(st.nextToken()); // 원판에 적힌 숫자의 수
        t = Integer.parseInt(st.nextToken()); // t번 회전

        circle = new int[n+1][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            turn(x, d, k);
            arrange();
        }

        int[] res = total();
        System.out.println(res[0]);
    }

    // x의 배수인 원판을 d방향으로 k칸 회전 (d:0 = 시계, 1 = 반시계)
    private static void turn(int x, int d, int k) {
        int tmp;
        for (int i = x; i <= n; i += x) {
            switch (d) {
                case 0:
                    for (int w = 0; w < k; w++) {
                        tmp = circle[i][m-1];
                        for (int j = m - 1; j > 0; j--) {
                            circle[i][j] = circle[i][j-1];
                        }
                        circle[i][0] = tmp;
                    }
                    break;
                case 1:
                    for (int w = 0; w < k; w++) {
                        tmp = circle[i][0];
                        for (int j = 0; j < m - 1; j++) {
                            circle[i][j] = circle[i][j+1];
                        }
                        circle[i][m-1] = tmp;
                    }
                    break;
            }
        }
    }

    // 원판에서 인접하면서 같은 수를 삭제한다 
    // 인접한 수가 하나도 없으면, 원판에 적힌 수의 평균을 구하고, 큰수는 -1, 작은수는 +1
    // 원소 기준 -> j-1, j+1 확인 (-1이 음수일 경우 m-1 확인, +1이 m 이상일 경우 0 확인)
    // 원판 기준 -> i-1, i+1 행의 같은 열 확인 (-1이 0일 경우 구하지 않고, +1이 n 초과일 경우 구하지 않는다
    // -> c[i][j-1], c[i][j+1], c[i-1][j], c[i+1][j] 확인
    // 바로 지우면 안됨!!!! 큐에 넣고, 다 확인 후 지워야 함
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static void arrange() {
        Queue<int[]> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = circle[i][j];
                if (cur == 0) continue;
                boolean check = false;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    int next;

                    if (nc < 0) nc = m-1;
                    if (nc >= m) nc = 0;

                    if (nr > 0 && nr <= n && nc >= 0 && nc < m) {
                        next = circle[nr][nc];
                        if (cur == next) {
                            check = true;
                            nums.add(new int[] {nr, nc});
                        }
                    }
                }

                if (check) nums.add(new int[] {i, j});
            }
        }

        if (nums.isEmpty()) {
            int[] res = total();
            double avg = (double)res[0] / (double)res[1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (circle[i][j] == 0) continue;

                    if (circle[i][j] > avg) {
                        circle[i][j]--;
                    } else if (circle[i][j] < avg) {
                        circle[i][j]++;
                    }
                }
            }
        } else {
            while (!nums.isEmpty()) {
                int[] now = nums.poll();

                int r = now[0];
                int c = now[1];

                circle[r][c] = 0;
            }
        }
    }

    static int[] total() {
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] > 0) {
                    cnt++;
                    sum += circle[i][j];
                }
            }
        }
        return new int[] {sum, cnt};
    }
}
