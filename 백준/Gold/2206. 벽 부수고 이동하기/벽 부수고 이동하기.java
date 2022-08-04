import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int x, y, wall;

        public Pos(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    static int n, m;
    static int[][] map;
    static int[][][] cnt; // 방문체크 && 거리 기록 %% 벽 부쉈는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cnt = new int[n][m][2]; // cnt[][][0] -> 벽안부숨, cnt[][][1] -> 벽부숨
        cnt[0][0][0] = 1; // 시작점부터 1 세기

        // input
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(new Pos(0, 0, 0)));
//        bfs(new Pos(0, 0, 0));
//        System.out.println( == 0 ? -1 : cnt[n-1][m-1][1]);

    }

    static int bfs(Pos p) {
        Queue<Pos> q = new LinkedList<>();
        q.add(p);

        int[] dx = {0, 0, -1, 1}; // 좌우
        int[] dy = {-1, 1, 0, 0}; // 상하

        while(!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int wall = now.wall;

            if (x == n - 1 && y == m - 1) return cnt[n-1][m-1][wall];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 1. 벽이 아닐 경우 && 방문하지 않았을 경우
                    if (map[nx][ny] == 0 && cnt[nx][ny][wall] == 0) {
                        cnt[nx][ny][wall] = cnt[x][y][wall] + 1;
                        q.add(new Pos(nx, ny, wall));
                    }
                    // 2. 벽일 경우 && 아직 부수지 않은 경우 && 방문하지 않았을 경우
                    else if (map[nx][ny] == 1 && wall == 0 && cnt[nx][ny][wall] == 0) {
                        cnt[nx][ny][wall + 1] = cnt[x][y][wall] + 1;
                        q.add(new Pos(nx, ny,  wall + 1));
                    }
                }
            }
        }

        return -1;
    }
}
