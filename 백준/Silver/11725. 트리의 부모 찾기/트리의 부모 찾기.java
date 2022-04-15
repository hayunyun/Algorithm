import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] graph;
    static int[] parent;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph[to].add(from);
            graph[from].add(to);
        }

        dfs(1);
        for (int i = 2; i <= n; i++)
            System.out.println(parent[i]);
    }

    static void dfs(int start) {
        for (int child : graph[start]) {
            if (visit[child]) continue;
            parent[child] = start;
            visit[child] = true;
            dfs(child);
        }
    }

}