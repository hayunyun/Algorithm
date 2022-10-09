import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int d, w, k, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MAX_VALUE;
            medicine(0, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static void medicine(int idx, int cnt) {
        if (k == 1) {
            ans = 0;
            return;
        }
        if (cnt > k) return;
        if (cnt >= ans) return;

        if (check()) {
            ans = cnt;
            return;
        }

        // 약물주입 -> 조합
        for (int i = idx; i < d; i++) {
            int[] tmp = map[i].clone();

            // 0으로 싹 다 바꾸기
            Arrays.fill(map[i], 0);
            medicine(i + 1, cnt + 1);

            // 1로 싹 다 바꾸기
            Arrays.fill(map[i], 1);
            medicine(i + 1, cnt + 1);

            // 복구
            map[i] = tmp;
        }
    }

    static boolean check() {
        int cnt;
        for (int i = 0; i < w; i++) {
            int cur = map[0][i];
            cnt = 1;
            for (int j = 1; j < d; j++) {
                // 다음 행의 특성이 현재 특성과 같다면 개수 카운트
                if (map[j][i] == cur) {
                    cnt++;
                    if (cnt == k) break;
                    // 다음 행의 특성이 현재 특성과 다르다면, 기준점 새로 잡고 개수 초기화
                } else {
                    cur = map[j][i];
                    cnt = 1;
                }
            }
            if (cnt < k) return false;
        }
        return true;
    }
}
