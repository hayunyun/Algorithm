import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    두 지점의 거리차가 1000 이하라면 이동
    모든 가능한 인근 정점을 탐색하고,
    도착지도 탐색했다면 happy 아니면 sad
     */
    static int n;
    static int[][] map;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n + 2][2];
            vis = new boolean[n + 2];

            // 집
            st = new StringTokenizer(br.readLine());
            map[0][0] = Integer.parseInt(st.nextToken());
            map[0][1] = Integer.parseInt(st.nextToken());

            // 편의점
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            // 락페스티벌
            st = new StringTokenizer(br.readLine());
            map[n + 1][0] = Integer.parseInt(st.nextToken());
            map[n + 1][1] = Integer.parseInt(st.nextToken());

            bfs();
            if (vis[n + 1]) sb.append("happy");
            else sb.append("sad");

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {map[0][0], map[0][1]});
        vis[0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 1; i < n + 2; i++) {
                if (!vis[i]) {
                    if (check(now[0], now[1], map[i][0], map[i][1])) {
                        q.add(new int[] {map[i][0], map[i][1]});
                        vis[i] = true;
                    }
                }
            }
        }

    }

    static boolean check(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 1000;
    }
}
