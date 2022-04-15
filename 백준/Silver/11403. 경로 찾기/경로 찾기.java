import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static int[][] matrix;
    static ArrayList<Integer> [] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        check = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1)
                    graph[i].add(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = bfs(i + 1, j + 1);
                    for (int z = 0; z <= n; z++) check[z] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int from, int to) {
        Queue<Integer> q = new LinkedList<>();
        q.add(from);

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now != from) check[now] = true;
            for (int info : graph[now]) {
                if (info == to) return 1;
                if (check[info]) continue;
                q.add(info);
            }
        }
        return 0;
    }
}