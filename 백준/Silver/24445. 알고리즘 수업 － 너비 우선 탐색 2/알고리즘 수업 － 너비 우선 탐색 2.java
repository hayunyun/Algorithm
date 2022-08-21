import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] cnts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        cnts = new int[n + 1];

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
            graph[i].sort(Collections.reverseOrder());
        }

        bfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(cnts[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void bfs (int start) {
        int c = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        cnts[start] = c++;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int n : graph[now]) {
                if (cnts[n] == 0) {
                    q.add(n);
                    cnts[n] = c++;
                }
            }
        }
    }
}
