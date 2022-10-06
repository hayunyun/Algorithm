import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    두 가로선이 연속하거나 서로 접하면 안된다
    i번 세로선의 결과가 i번이 나와야 한다
    추가해야 하는 가로선 개수의 최솟값? (3개 이상이면 -1)
     */
    
    static int n, m, h, ans;
    static boolean[][] ladder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로선
        m = Integer.parseInt(st.nextToken()); // 가로선
        h = Integer.parseInt(st.nextToken()); // 가로선 놓을수 있는 개수
        ladder = new boolean[h+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a번 가로에서 연결
            int b = Integer.parseInt(st.nextToken()); // b와 b+1 세로선 연결
            ladder[a][b] = true;
        }

        ans = Integer.MAX_VALUE;
        find(1, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1: ans);
    }

    // 가능한 부분에 다 놓아보며, 놓을 때마다 i==i인지 확인, 하나라도 아니면 return
    static void find(int r, int cnt) {
        if (cnt > 3) return;

        // i == i 인지 확인
        if (game()) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = r; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                // 사다리가 아니고, 좌우에도 사다리가 없다면
                if (!ladder[i][j] && leftRight(i, j)) {
                    ladder[i][j] = true; // 사다리 놓기
                    find(i, cnt + 1);
                    ladder[i][j] = false;
                }
            }
        }

    }

    static int[] dc = {-1, 1};
    static boolean leftRight(int r, int c) {
        for (int i = 0; i < 2; i++) {
            int nr = r;
            int nc = c + dc[i];
            if (nc >= 1 && nc < n) {
                // 좌우에 사다리가 있다면 false
                if (ladder[nr][nc]) return false;
            }
        }
        // 없으면 true
        return true;
    }

    static boolean game() {
        for (int i = 1; i <= n; i++) {
            int pos = i;
            for (int j = 1; j <= h; j++) {
                // 본인 이전 열이 true라면 -1열로 이동
                if (ladder[j][pos-1]) {
                    pos -= 1;
                }
                // 본인 열이 true라면 +1열로 이동
                else if (ladder[j][pos]) {
                    pos += 1;
                }
            }
            if (pos != i) return false;
        }

        return true;
    }
}
