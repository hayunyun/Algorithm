import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static ArrayList<Integer> [] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to].add(from);
            graph[from].add(to);
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int now) {
        if (visit[now]) return;

        visit[now] = true;
        for (int next : graph[now]) {
            dfs(next);
        }
    }
}