import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> [] graph;
    static boolean flag;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            vis[i] = true;
            dfs(i, 0);
            vis[i] = false;
        }

        System.out.println(flag ? 1 : 0);
    }

    static void dfs(int node, int depth) {
        if (flag) return;
        
        if (depth == 4) {
            flag = true;
            return;
        }

        for (int i = 0; i < graph[node].size(); i++) {
            int now = graph[node].get(i);
            if (!vis[now]) {
                vis[now] = true;
                dfs(now, depth + 1);
                vis[now] = false;
            }
        }
    }
}
