import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static ArrayList<Integer> [] graph;
    static int[] arr;
    static int n, m, value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        arr = new int [n];
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
        value = 0;
        dfs(1);
        System.out.println(value - 1);
    }

    public static void dfs(int start) {
        if (!check[start]) {
            check[start] = true;
            for (int i = 0; i < graph[start].size(); i++) {
                dfs(graph[start].get(i));
            }
            value += 1;
        }
    }
}