import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] map = new int[t][t];
        boolean[][] visited = new boolean[t][t];
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        boolean reach = false;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            visited[nowX][nowY] = true;

            if (map[nowX][nowY] == -1) {
                reach = true;
                break;
            }

            if (nowX + map[nowX][nowY] < t && !visited[nowX + map[nowX][nowY]][nowY]) {
                q.add(new int[] {nowX + map[nowX][nowY], nowY});
            }

            if (nowY + map[nowX][nowY] < t && !visited[nowX][nowY + map[nowX][nowY]]) {
                q.add(new int[] {nowX, nowY + map[nowX][nowY]});
            }
        }

        if (reach) System.out.println("HaruHaru");
        else System.out.println("Hing");

    }
}