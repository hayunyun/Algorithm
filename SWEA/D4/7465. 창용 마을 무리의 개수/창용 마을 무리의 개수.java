import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    static int ans;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            vis = new boolean[n];
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;

                graph[a].add(b);
                graph[b].add(a);
            }

            ans = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) bfs(i);
            }

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);

                if (!vis[next]) {
                    q.add(next);
                    vis[next] = true;
                }
            }
        }

        ans++;
    }
}
