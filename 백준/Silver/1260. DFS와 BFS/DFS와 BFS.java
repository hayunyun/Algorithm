import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static ArrayList<Integer> [] graph;
    static int[] arr;
    static int n, m, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        arr = new int [n];
        check = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n + 1; i++) {
            graph[i].sort(Comparator.comparingInt(o -> o));
        }

        dfs(v, 0);
        sb.append("\n");
        // check 초기화
        for (int i = 0; i < check.length; i++) check[i] = false;
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int start, int index) {
        if (!check[start]) {
            check[start] = true;
            sb.append(start).append(" ");
            for (int i = 0; i < graph[start].size(); i++) {
                int now = graph[start].get(i);
                dfs(now, index + 1);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()) {
            int now = q.poll();
            if (!check[now]) {
                for (int i = 0; i < graph[now].size(); i++) {
                    q.add(graph[now].get(i));
                }
                check[now] = true;
                sb.append(now).append(" ");
            }
        }
    }
}