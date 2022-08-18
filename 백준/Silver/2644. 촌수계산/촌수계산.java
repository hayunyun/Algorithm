import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        System.out.println(bfs(p1, p2));
    }

    static int bfs(int p1, int p2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {p1, 0});
        vis[p1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int cnt = now[1];

            if (pos == p2) {
                return cnt;
            }

            for (int i = 0; i < graph[pos].size(); i++) {
                int near = graph[pos].get(i);
                if (!vis[near]) {
                    vis[near] = true;
                    q.add(new int[] {near, cnt + 1});
                }
            }
        }

        return -1;
    }
}
