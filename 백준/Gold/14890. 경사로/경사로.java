import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, l;
    static int[][] map;
    static int[] load;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = check(i, 0, 0); // 행 방향 확인
            ans += a;
            a = check(0, i, 1); // 열 방향 확인
            ans += a;
        }

        System.out.println(ans);
    }

    /*
    지금 값보다 다음 값이
    - 같으면 : 개수++, 다음칸 이동
    - 크면 : 1 초과로 크면 return
            1 크면, 지금까지 카운트한 개수가 l개 미만이면 return, l개 이상이면 다음칸 이동
    - 작으면 : 1 초과로 작으면 return
             1 작으면, 앞으로 몇개의 개수가 같은지 체크(숫자 달라질때까지 카운트), l개 미만이면 return, l개 이상이면 다음칸 이동
     mode = 0 : 행(가로방향), 1 : 열 (세로방향)
     */
    private static int check(int a, int b, int mode) {
        int cur = map[a][b];
        int cnt = 1;
        if (mode == 1) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        boolean[] way = new boolean[n]; // 경사로 설치
        int next;
        for (int i = b + 1; i < n; i++) {
            if (mode == 0) {
                next = map[a][i];
            } else {
                next = map[i][a];
            }

            if (cur == next) {
                cnt++;
            // 현재값보다 다음값이 크면 -> '현재값에' 경사로 설치
            } else if (cur < next) {
                if (next - cur > 1) return 0; // 차이가 1보다 크면 return
                if (cnt < l) return 0; // 같은 칸 개수가 l 미만이면 return

                // '현재값'부터 뒤돌아가며 l만큼 경사로 깔기
                for (int j = 1; j <= l; j++) {
                    if (i - j < 0) return 0; // 범위 벗어나면 return
                    if (way[i - j]) return 0; // 이미 경사로가 깔려 있으면 return
                }

                for (int j = 1; j <= l; j++) {
                    way[i - j] = true; // l개수만큼 경사로 설치
                }

                cnt = 1; // cnt 초기화 && 다음칸 확인
            // 현재값보다 다음값이 작으면
            } else {
                if (cur - next > 1) return 0; // 차이가 1보다 크면 return

                // '다음값'부터 경사로 설치 가능한지 확인 (앞의 몇칸까지 같은지 확인 - l개까지만 확인하면 됨)
                for (int j = 0; j < l; j++) {
                    if (i + j >= n) return 0; // 범위 벗어나면 return
                    if (way[i + j]) return 0; // 이미 경사로가 깔려 있으면 return
                    int neNe;
                    if (mode == 0) {
                        neNe = map[a][i + j];
                    } else {
                        neNe = map[i + j][a];
                    }
                    if (next != neNe) return 0; // 값 다르면 return
                }

                for (int j = 0; j < l; j++) {
                    way[i + j] = true; // 경사로 깔기
                }

                cnt = 1; // cnt 초기화 && 다음칸 확인
            }
            cur = next;
        }
        return 1;
    }
}
