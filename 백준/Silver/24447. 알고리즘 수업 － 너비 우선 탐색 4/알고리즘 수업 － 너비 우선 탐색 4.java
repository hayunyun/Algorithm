import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static long cnt, ans;
    static ArrayList<Integer>[] graph;
    static int[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        vis = new int[n + 1];
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

        vis[r] = 1;
        cnt = 1;
        bfs(r);
        System.out.println(ans);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int depth = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int now = q.poll();
                ans += cnt * depth;
                cnt++;

                for (int j = 0; j < graph[now].size(); j++) {
                    int next = graph[now].get(j);
                    if (vis[next] == 0) {
                        q.add(next);
                        vis[next] = vis[now] + 1;
                    }
                }
            }
            depth++;
        }

    }
}
