import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        public int to, weight;

        public Edge(int t, int w) {
            this.to = t;
            this.weight = w;
        }
    }

    static class Info {
        public int index, dist;

        public Info (int i, int d) {
            this.index = i;
            this.dist = d;
        }
    }

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        edges = new ArrayList[N+1]; // 인접리스트 (to, weight) - 해당 인덱스에서 to 까지 가는 데 weight 만큼의 비용이 듦
        dist = new int[N+1]; // 시작점에서 해당 인덱스 정점까지의 거리

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        // 값 확인
//        for (int i = 1; i <= N; i++) {
//            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
//            else sb.append(dist[i]).append('\n');
//        }
//        System.out.println(sb);
        System.out.print(dist[end]);
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for (int i = 1; i <= N ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보를 기록에 추가하고 거리 배열에 갱신
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 갱신 반복
        while (!pq.isEmpty()) {
            Info info = pq.poll();
            // 현재 꺼낸 값이 가치있는가?
            // -> 기록된 거리보다 현재 꺼낸 값의 거리가 더 크다면 갱신할 필요 X
            if (dist[info.index] < info.dist) continue;
            for (Edge e: edges[info.index]) { // 인접한 간선들 하나씩 확인
                if (dist[info.index] + e.weight >= dist[e.to]) continue; // 만약 새롭게 찾은 거리가 원래 거리보다 크다면 갱신 X
                // 아니라면
                dist[e.to] = dist[info.index] + e.weight; // 갱신
                pq.add(new Info(e.to, dist[e.to])); // 새로운 정보 pq에 넣어주기
            }
        }
    }
}
