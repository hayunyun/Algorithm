import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        bfs(r);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n + 1];
        vis[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (vis[next] == 0) {
                    q.add(next);
                    vis[next] = vis[now] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(vis[i] - 1).append("\n");
        }
        System.out.println(sb);
    }
}
