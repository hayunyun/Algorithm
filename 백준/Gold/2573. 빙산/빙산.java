import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pos> ice = new LinkedList<>();
    static Queue<Integer> melt = new LinkedList<>();
    static int n, m;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}; // 상하
    static int[] dc = {0, 0, -1, 1}; // 좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        
        while (true) {
            // 한덩이인지 확인, 한덩이라면 계속 반복
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        ice.add(new Pos(i, j));
                        checkMelt(i, j);
                    }
                }
            }

            if (ice.isEmpty()) {
                year = 0;
                break;
            }
            if (!(bfs(ice.peek().x, ice.peek().y) == ice.size())) break;

            // 얼음큐 - 정보큐 해서 맵에 갱신
            while (!ice.isEmpty()) {
                Pos now = ice.poll();
                int x = now.x;
                int y = now.y;

                map[x][y] -= melt.poll();
                if (map[x][y] < 0) map[x][y] = 0;
            }

            year++;
        }

        System.out.println(year);
    }

    static int bfs(int r, int c) {
        boolean[][] vis = new boolean[n][m];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r, c));
        int cnt = 1;
        vis[r][c] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.x + dr[i];
                int nc = now.y + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (map[nr][nc] != 0 && !vis[nr][nc]) {
                        q.add(new Pos(nr, nc));
                        vis[nr][nc] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static void checkMelt(int r, int c) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (map[nr][nc] == 0) cnt++;
            }
        }
        melt.add(cnt);
    }

}
