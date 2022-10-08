import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    static int n, m, r;
    static int[] items, dist;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 수색범위
        r = Integer.parseInt(st.nextToken()); // 길의개수

        items = new int[n];
        dist = new int[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dijkstra(i);
            
            // 아이템 최댓값 구하기
            int total = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= m) {
                    total += items[j];
                }
            }
            max = Math.max(max, total);
        }

        System.out.println(max);
    }

    static void dijkstra(int start) {
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nd = pq.poll();

            if (nd.dist > dist[nd.to]) continue;
            for (Node next : graph[nd.to]) {
                if (dist[next.to] > dist[nd.to] + next.dist) {
                    dist[next.to] = dist[nd.to] + next.dist;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}
