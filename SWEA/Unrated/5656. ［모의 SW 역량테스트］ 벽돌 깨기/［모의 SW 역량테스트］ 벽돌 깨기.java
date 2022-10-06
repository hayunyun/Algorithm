import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int n, w, h, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Point {
        int r,c,cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    /*
    1. 구슬 던지기 -> 중복순열 (12^4로 시간복잡도 문제 x)
    2. 구슬에 맞는 벽돌 처리(동시에 모두 처리) -> BFS (DFS로도 가능하지만, BFS가 좀 더 적합)
    3. 빈 공간 없이 벽돌 내리기 (중력처리)
    4. 남은 벽돌개수 구하고, 최솟값 갱신
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t ; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // n개의 구슬
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MAX_VALUE;
            game(0, map);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void game(int round, int[][] map) {
        if (round == n) {
            int res = getRemain(map);
            ans = Math.min(ans, res);
            return;
        }

        // 구슬 던지기 -> 중복순열
        // 맨 위에서 0이 아닐때까지 행++ 하며 떨어짐
        for (int col = 0; col < w; col++) {
            int row = 0;
            while (row < h && map[row][col] == 0) row++;

            if (row == h) { // 맞는 벽돌이 없다면
                game(round + 1, map);
            }
            else { // 맞는 벽돌이 있다면
                // 배열 복사
                int[][] newMap = new int[h][w];
                for (int r = 0; r < h; r++) {
                    for (int c = 0; c < w; c++) {
                        newMap[r][c] = map[r][c];
                    }
                }

                boom(newMap, row, col); // 제거 벽돌 연쇄 처리
                down(newMap); // 벽돌 내리기
                game(round + 1, newMap);
            }
        }
    }

    private static int getRemain(int[][] map) {
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] > 0) res++;
            }
        }
        return res;
    }

    static Stack<Integer> stack = new Stack<>();
    private static void down(int[][] map) {
        for (int c = 0; c < w; c++) {
            // 위의 행부터 남은 벽돌 스택에 넣기
            for (int r = 0; r < h; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }

            // 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸이 된 상태
            // 밑의 행부터 다시 채워준다
            int nr = h - 1;
            while(!stack.isEmpty()) {
                map[nr--][c] = stack.pop();
            }
        }
    }

    // BFS
    private static void boom(int[][] map, int r, int c) {
        Queue<Point> q = new LinkedList<>();
        if (map[r][c] > 1) {
            q.add(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; // 벽돌 파괴 && 방문처리

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 상하좌우 한번씩 보며 파괴
            for (int i = 0; i < 4; i++) {
                int nr = p.r;
                int nc = p.c;
                for (int j = 1; j < p.cnt; j++) {
                    nr += dr[i];
                    nc += dc[i];
                    if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                        if (map[nr][nc] > 0) {
                            if (map[nr][nc] > 1) {
                                q.add(new Point(nr, nc, map[nr][nc]));
                            }
                            map[nr][nc] = 0;
                        }
                    }
                }
            }
        }
    }
}
