import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> [] adj;

    // x를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y: adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while(!q.isEmpty()) {
            x = q.poll();
            sb.append(x).append(' ');
            for (int y: adj[x]) {
                if (visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) visit[i] = false; // 초기화
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점
        M = Integer.parseInt(st.nextToken()); // 간선
        V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        
        // 작은 번호부터 가도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        pro();
    }
}
