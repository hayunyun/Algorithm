import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    사각지대의 최소크기를 구하자!
     */
    static int n, m, ans;
    static int[][] map;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        // input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 & map[i][j] <= 5) {
                    cctv.add(new int[] {i, j});
                }
            }
        }

        ans = Integer.MAX_VALUE;
        find(0, map);
        System.out.println(ans);
        /*
        cctv의 수 만큼 시야를 다 확인한 후 최소 사각지대 갱신
         */
    }

    static void find(int cnt, int[][] map) {
        if (cnt == cctv.size()) {
            int score = calMin(map);
            if (score < ans) {
                ans = score;
            }
            return;
        }

        int[] cam = cctv.get(cnt);
        int r = cam[0];
        int c = cam[1];
        int[][] newMap = new int[n][m];
        switch (map[r][c]) {
            case 1:
                // 본인위치에서 상하좌우
                for (int i = 0; i < 4; i++) {
                    newMap = camSet(r, c, i, map);

                    find(cnt + 1, newMap);
                }
                break;
            case 2:
                // 상하, 좌우
                for (int i = 0; i < 4; i += 2) {
                    newMap = camSet(r, c, i, map);
                    newMap = camSet(r, c, i+1, newMap);

                    find(cnt + 1, newMap);
                }

                break;
            case 3:
                // 좌상, 좌하, 우상, 우하
                for (int i = 2; i < 4; i++) {
                    for (int j = 0; j <= 1; j++) {
                    	newMap = camSet(r, c, i, map);
                    	newMap = camSet(r, c, j, newMap);

                        find(cnt + 1, newMap);
                    }
                }
                break;
            case 4:
                // 좌상우, 상우하, 우하좌, 하좌상
                // 1씩 증가
                int num = 0;
                for (int i = 0; i < 4; i++) {
                	newMap = camSet(r, c, (num % 4), map);
                    newMap = camSet(r, c, ((num+1) % 4), newMap);
                    newMap = camSet(r, c, ((num+2) % 4), newMap);

                    find(cnt + 1, newMap);
                    num++;
                }
                break;
            case 5:
                // 상하좌우
            	newMap = camSet(r, c, 0, map);
                newMap = camSet(r, c, 1, newMap);
                newMap = camSet(r, c, 2, newMap);
                newMap = camSet(r, c, 3, newMap);

                find(cnt + 1, newMap);
                break;
        }
    }

    static int calMin(int[][] map) {
        int zero = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) zero++;
            }
        }
        return zero;
    }

    static int[][] camSet(int nr, int nc, int d, int[][] map) {
    	// 설치할 때 새 배열 만들고, 그것을 return
    	int[][] nowMap = new int[n][m];
    	for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	nowMap[i][j] = map[i][j];
            }
    	}
    	
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) break;
            if (nowMap[nr][nc] == 0) nowMap[nr][nc] = -1;
            if (nowMap[nr][nc] == 6) break;
        }
        
        return nowMap;
    }
}