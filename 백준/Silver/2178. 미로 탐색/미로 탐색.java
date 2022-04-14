import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] cnt = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        cnt[0][0] = 1;

        int[] dx = {0, 0, -1, 1}; // 좌우
        int[] dy = {1, -1, 0, 0}; // 상하

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                q.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                cnt[nextX][nextY] = cnt[nowX][nowY] + 1;
            }
        }

        System.out.println(cnt[n - 1][m - 1]);
    }
}