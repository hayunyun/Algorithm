import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, maxCore, minLine;
    static int[][] map;
    static ArrayList<int[]> cores;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    /*
    가장자리의 코어는 이미 연결된 상태
    '최대'한 많은 코어를 연결했을 때의 '최소' 전선 길이를 구하자.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            cores = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) cores.add(new int[] {i, j});
                }
            }

            maxCore = Integer.MIN_VALUE;
            minLine = Integer.MAX_VALUE;
            check(0, 0, 0);

            sb.append("#").append(tc).append(" ");
            sb.append(minLine).append("\n");
        }
        System.out.println(sb);
    }

    /*
    1. 맨 위, 왼쪽부터 보며 1일 경우 전선을 연결해본다.
    1-1. 코어가 0행 || n-1행 || 0열 || n-1열 일 경우 바로 다음 코어로 넘어간다. (전체 코어에 더하고 -> 일단생략)
    2. 상하좌우 가능한 방법으로 모두 수행해 본 후 가능할 경우 다음 코어로 백트래킹
    3. 마지막 코어까지 연결을 마치면, 전체 코어 개수를 확인하고, 최댓값을 갱신한다.
    4. 만약 현재 코어수가 최댓값이라면, 거리의 최솟값을 갱신한다.
     */

    static void check(int idx, int coreCnt, int lineCnt) {
        // 3. 마지막 코어까지 연결을 마치면,
        if (idx == cores.size()) {
            // 3-1. 전체 코어 개수를 확인하고, 최댓값을 갱신한다.
            if (coreCnt > maxCore) {
                maxCore = coreCnt;
                minLine = lineCnt;
            }
            // 4. 만약 현재 코어수가 최댓값이라면, 거리의 최솟값을 갱신한다.
            else if (coreCnt == maxCore) {
                minLine = Math.min(minLine, lineCnt);
            }
            return;
        }

        // 1. 맨 위, 왼쪽부터 보며 1일 경우를 살펴본다.
        int[] core = cores.get(idx);
        int r = core[0];
        int c = core[1];

        // 1-1. 현재 코어가 테투리와 닿아 있다면, 다음 코어로 넘어간다.
        if (r == 0 || c == 0 || r == n - 1 || c == n - 1) {
            check(idx + 1, coreCnt, lineCnt);
        }
        // 1-2. 닿아있지 않다면, 상하좌우 탐색 진행
        else {
            for (int i = 0; i < 4; i++) {

                boolean flag = false;
                int cnt = 0;

                int curR = r, curC = c;
                int nr, nc;
                while (true) {
                    nr = curR + dr[i];
                    nc = curC + dc[i];

                    // 테두리에 닿으면 좋료
                    if (nc < 0 || nc >= n || nr < 0 || nr >= n) break;

                    // 빈칸이면 전선 놓기
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = 2;
                        cnt++;
                    }
                    // 코어가 있거나, 전선이 있다면 더이상 탐색할 필요 없다
                    else {
                        flag = true;
                        break;
                    }

                    curR = nr; curC = nc;
                }

                // 코어, 전선과 마주치지 않고 무사히 탐색을 끝냈다면, 카운트를 추가해서 다음값으로 넘겨준다
                if (!flag) {
                    check(idx + 1, coreCnt + 1, lineCnt + cnt);
                    rollback(nr - dr[i], nc - dc[i], i); // 되돌리기
                }
                // 코어, 전선과 마주쳤다면, 깔았던 전선을 모두 회수한 후 다음 값으로 넘어간다
                else {
                    rollback(nr - dr[i], nc - dc[i], i); // 되돌리기
                    check(idx + 1, coreCnt, lineCnt);
                }
            }
        }
    }

    // 되돌리기
    static void rollback(int nr, int nc, int i) {
        while (map[nr][nc] == 2) {
            map[nr][nc] = 0;
            nr -= dr[i];
            nc -= dc[i];
        }
    }
}
