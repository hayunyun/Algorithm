import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int next, wgt;

        public Info(int next, int wgt) {
            this.next = next;
            this.wgt = wgt;
        }
    }

    static int n, m;
    static ArrayList<Info> [] map;
    static PriorityQueue<Info> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1]; // 0 (입구) ~ n
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            w = (w == 1) ? 0 : 1; // 내리막길은 0, 오르막길은 1

            map[a].add(new Info(b, w));
            map[b].add(new Info(a, w));
        }

        pq = new PriorityQueue<>((o1, o2) -> o1.wgt - o2.wgt); // 최적경로
        int min = prim();
        pq = new PriorityQueue<>((o1, o2) -> o2.wgt - o1.wgt); // 최악경로
        int max = prim();

        System.out.println(max - min);
    }

    static int prim() {
        boolean[] vis = new boolean[n + 1];
        pq.addAll(map[0]);
        vis[0] = true;

        int cost = 0;
        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (!vis[now.next]) {
                vis[now.next] = true;
                cost += now.wgt;
                pq.addAll(map[now.next]);
            }
        }

        return cost * cost;
    }
}
