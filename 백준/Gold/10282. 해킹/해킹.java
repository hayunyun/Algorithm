import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int to, time;

        public Node(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static int n, d, start;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken()) - 1;

            graph = new ArrayList[n];
            dist = new int[n ];
            vis = new boolean[n ];
            for (int j = 0; j < n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int time = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, time));
            }

            djikstra();
            int ans = 0;
            int time = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    ans++;
                    time = Math.max(time, dist[j]);
                }
            }
            
            sb.append(ans).append(" ").append(time).append("\n");
        }

        System.out.println(sb);
    }

    static void djikstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dist[j] < min) {
                    min = dist[j];
                    minIdx = j;
                }
            }

            if (minIdx == -1) break;
            vis[minIdx] = true;

            for (int j = 0; j < graph[minIdx].size(); j++) {
                Node nd = graph[minIdx].get(j);
                if (dist[nd.to] > dist[minIdx] + nd.time) {
                    dist[nd.to] = dist[minIdx] + nd.time;
                }
            }
        }
    }
}
