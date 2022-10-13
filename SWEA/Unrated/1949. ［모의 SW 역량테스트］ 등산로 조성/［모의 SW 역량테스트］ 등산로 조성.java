import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int n, k, ans;
    static int[][] map;
    static ArrayList<int[]> top;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            int max = -1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            top = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == max) {
                        top.add(new int[] {i, j});
                    }
                }
            }

            ans = Integer.MIN_VALUE;

            // 하나씩 0~k깎고 등산로 재기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int tmp = map[i][j];
                    for (int l = 0; l < k; l++) {
                        if (--map[i][j] < 0) break;
                        for (int[] now : top) {
                            findWay(now[0], now[1], 1);
                        }
                    }
                    map[i][j] = tmp;
                }
            }

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void findWay(int r, int c, int cnt){
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (map[nr][nc] < map[r][c]) {
                    findWay(nr, nc, cnt + 1);
                } else {
                    ans = Math.max(ans, cnt);
                }
            }
        }
    }
}
