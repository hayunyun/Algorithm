import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static ArrayList<Integer> [] graph;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        System.out.println(bfs(1) - 1);
    }

    public static int bfs(int start) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (!check[now]) {
                check[now] = true;
                for(int val : graph[now]) {
                    q.add(val);
                }
                ans++;
            }
        }

        return ans;
    }
}