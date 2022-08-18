import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int[] vis;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        vis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        StringBuilder sb = new StringBuilder();
        cnt = 1;
        dfs(start);
        for (int i = 1; i <= n; i++) {
            sb.append(vis[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        vis[node] = cnt++;
        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (vis[next] == 0) {
                dfs(next);
            }
        }
    }
}
