import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static int n, m, total;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m==0 && n==0) break;

            graph = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                graph[i] = new ArrayList<>();
            }

            total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                total += c;

                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            prim();
            sb.append(total).append("\n");
        }
        System.out.println(sb);

    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        boolean[] vis = new boolean[m];
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            if (!vis[nd.to]) {
                vis[nd.to] = true;
                total -= nd.dist;
                pq.addAll(graph[nd.to]);
            }

        }
    }
}
