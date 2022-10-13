import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    1. 입력 받고, 하나씩 보며 1이 있을 때마다 탐색 들어감
    2. 큰것부터 작아지며 가능한 색종이를 붙이고 넘긴다 (백트래킹)
    3. 모든 색종이가 덮여지면 현재 카운트값과 기록된 값을 비교하고 최솟값을 갱신한다.
     */
    static int ans;
    static int[][] map = new int[10][10];
    static int[] papers = {5, 5, 5, 5, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;
        cover(0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void cover(int r, int c, int cnt) {
        if (cnt > ans) return;

        // 현재 열이 끝이면 행++ && 열 초기화
        if (c > 9) {
            cover(r + 1, 0, cnt);
            return;
        }

        if (r > 9) {
            if (isZero()) {
                ans = Math.min(ans, cnt);
            }
            return;
        }

        if (map[r][c] == 1) {
            // 색종이 붙이는 시도를 해본다. 큰것부터 크기를 줄여가며 붙인다
            for (int i = 4; i >= 0; i--) {
                if (isOne(r, c, i)) {
                    // 색종이의 면적만큼 모두 1인가 확인
                    if (papers[i] > 0) {
                        getPaper(r, c, i, 0); // 색종이 붙이기
                        papers[i]--;

                        cover(r, c + 1, cnt + 1);

                        getPaper(r, c, i, 1); // 색종이 다시 떼기
                        papers[i]++;
                    }
                }
            }
        } else {
            // 현재 열이 끝이 아니면 열++
            cover(r, c + 1, cnt);
        }
    }

    // 색종이가 다 붙여졌나 확인
    static boolean isZero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] != 0) return false;
            }
        }
        return true;
    }

    static boolean isOne(int r, int c, int paper) {
        if (r+paper >= 10 || c+paper >= 10) return false;

        for (int i = r; i <= r + paper; i++) {
            for (int j = c; j <= c + paper; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    // 색종이 붙였다 떼기
    // mode = 0: 색종이로 덮기, 1: 색종이 다시 떼기
    static void getPaper(int r, int c, int paper, int mode) {
        for (int i = r; i <= r + paper; i++) {
            for (int j = c; j <= c + paper; j++) {
                map[i][j] = mode;
            }
        }
    }
}
