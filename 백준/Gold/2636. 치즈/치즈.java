import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static boolean flag;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] check;
    static Queue<int[]> cheese;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 테두리만 bfs
        int time = 0;
        int cnt = 0;
        while (true) {
            check = new boolean[r][c];
            cheese = new LinkedList<>();
            bfs(0, 0);

            if (cheese.isEmpty()) break;
            cnt = cheese.size();

            while (!cheese.isEmpty()) {
                int[] now = cheese.poll();
                map[now[0]][now[1]] = 0;
            }
            time++;
        }

        System.out.println(time);
        System.out.println(cnt);
    }

    // 1에 닿을 떄까지 순회
    static void bfs(int row, int col) {
        boolean[][] vis = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        vis[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                    if (check[nr][nc]) continue;

                    if (!vis[nr][nc]) {
                        if (map[nr][nc] == 0) {
                            q.add(new int[] {nr, nc});
                            vis[nr][nc] = true;
                        } else {
                            cheese.add(new int[] {nr, nc});
                            check[nr][nc] = true;
                        }
                    }
                }
            }

        }

    }
}
