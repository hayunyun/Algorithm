import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class info implements Comparable<info> {
        int node;
        int distance;

        public info(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(info o) {
            return Integer.compare(distance, o.distance);
        }
    }
    
    static ArrayList<info> [] Map;
    static int[] Distance;
    static int start;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점
        int E = Integer.parseInt(st.nextToken()); // 간선

        // 그래프 초기화
        Map = new ArrayList [V+1]; // (목적지 정점, 거리) 정보 저장
        Distance = new int [V+1]; // 각 정점의 거리 정보 저장
        for (int i = 1; i <= V; i++) { // 일단 죄다 무한대로 시작
            Map[i] = new ArrayList<>();
            Distance[i] = INF;
        }

        int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        int u, v, w;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()); // from
            v = Integer.parseInt(st.nextToken()); // to
            w = Integer.parseInt(st.nextToken()); // 가중치

            Map[u].add(new info(v, w)); 
        }

        findShortestPath(K);

        for (int i = 1; i <= V; i++) {
            if (Distance[i] != INF) // 값이 갱신되었다면
                bw.write(Distance[i] + "\n");
            else
                bw.write("INF" + "\n");
        }

        bw.flush();
        bw.close();
    }

    // 다익스트라
    static void findShortestPath(int start) {
        PriorityQueue<info> pq = new PriorityQueue<>(); // 우선순위큐(최소힙)으로 다익스트라 구현
        Distance[start] = 0; // 시작점의 초기상태는 0
        pq.add(new info(start, 0)); // 큐에 시작점 넣기

        while(!pq.isEmpty()) {
            info now = pq.poll();

            // 이미 저장되어 있는 값의 거리가 더 적을 경우 갱신할 필요 X
            if (now.distance > Distance[now.node]) continue;

            for (info next : Map[now.node]) { // 인접 정점 둘러보기
                if (Distance[next.node] > Distance[now.node] + next.distance) { // 현재 저장되어있는 거리보다 지금 기준정점의 거리+인접정점의 거리가 더 적다면
                    Distance[next.node] = Distance[now.node] + next.distance; // 갱신
                    pq.add(new info(next.node, Distance[next.node])); // 큐에 넣어주기
                }
            }
        }
    }
}