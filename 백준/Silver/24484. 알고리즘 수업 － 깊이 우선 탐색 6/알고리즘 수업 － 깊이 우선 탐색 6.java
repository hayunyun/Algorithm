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
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        vis[r] = 1;
        cnt = 1;
        dfs(r, 0);
        System.out.println(ans);
    }

    static void dfs(int node, long depth) {
        ans += depth * cnt;
        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (vis[next] == 0) {
                vis[next] = vis[node] + 1;
                cnt++;
                dfs(next, depth + 1);
            }
        }
    }
}
