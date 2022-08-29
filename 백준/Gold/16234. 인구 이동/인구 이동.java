import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, left, right, day;
    static int[][] map;
    static boolean[][] vis;
    static Queue<int[]> union;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean flag = false;
            vis = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) {
                            sumPeople(sum);
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) break;
            day++;
        }

        System.out.println(day);
    }

    static int bfs(int row, int col) {
        int sum = 0;

        Queue<int[]> q = new LinkedList<>();
        union = new LinkedList<>();
        
        q.add(new int[] {row, col});
        union.add(new int[] {row, col});
        vis[row][col] = true;
        sum += map[row][col];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int d = Math.abs(map[r][c] - map[nr][nc]);
                    if (!vis[nr][nc] && d >= left && d <= right) {
                        vis[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                        union.add(new int[] {nr, nc});
                        sum += map[nr][nc];
                    }
                }
            }
        }

        return sum;
    }

    static void sumPeople(int sum) {
        int people = sum / union.size();
        while (!union.isEmpty()) {
            int[] ctry = union.poll();
            map[ctry[0]][ctry[1]] = people;
        }
    }
}
