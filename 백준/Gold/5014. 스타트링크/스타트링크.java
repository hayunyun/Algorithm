import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static int[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); // 건물 총 층
        s = Integer.parseInt(st.nextToken()); // 강호가 지금 있는 층
        g = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
        u = Integer.parseInt(st.nextToken()); // 위로 u층 감
        d = Integer.parseInt(st.nextToken()); // 아래로 d층 감

        vis = new int[f + 1];
        bfs();
    }

    // 똑같은 층을 다시 갈 필요는 없다!!! 최솟값을 구하는 것이므로
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if (now == g) {
                System.out.println(vis[g] - 1);
                return;
            }

            int nu = now + u;
            if (nu <= f && vis[nu] == 0) {
                q.add(nu);
                vis[nu] = vis[now] + 1;
            }

            int nd = now - d;
            if (nd >= 1 && vis[nd] == 0) {
                q.add(nd);
                vis[nd] = vis[now] + 1;
            }
        }

        System.out.println("use the stairs");
    }
}
