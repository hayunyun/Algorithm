import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r, c;
        boolean isPerson;

        public Pos(int r, int c, boolean isPerson) {
            this.r = r;
            this.c = c;
            this.isPerson = isPerson;
        }
    }
    /*
    불 먼저 퍼지고 -> 상근이 이동
     */
    static int w, h;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] vis;
    static Queue<Pos> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            vis = new boolean[h][w];

            // input
            int[] now = new int[2];
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '*') {
                        q.add(new Pos(i, j, false));
                        vis[i][j] = true;
                    }
                    else if (map[i][j] == '@') {
                        now[0] = i; now[1] = j;
                        map[i][j] = '.';
                    }
                }
            }

            q.add(new Pos(now[0], now[1], true));
            vis[now[0]][now[1]] = true;

            // BFS
            int cnt = bfs();
            sb.append(cnt == -1 ? "IMPOSSIBLE" : cnt);
            sb.append("\n");
            
            q.clear();
        }
        System.out.println(sb);
    }

    private static int bfs() {
        int cnt = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Pos pos = q.poll();

                if (pos.isPerson && (pos.r == 0 || pos.r == h-1 || pos.c == 0 || pos.c == w-1)) {
                    return cnt;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = pos.r + dr[d];
                    int nc = pos.c + dc[d];

                    if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                        if (!vis[nr][nc] && map[nr][nc] == '.') {
                            if (!pos.isPerson) {
                                map[nr][nc] = '*';
                            }
                            vis[nr][nc] = true;
                            q.add(new Pos(nr, nc, pos.isPerson));
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}
