import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int x, y;
    static int[] vis = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= 100000; i++) {
            vis[i] = Integer.MAX_VALUE;
        }

        djikstra();
        System.out.println(vis[y]);
    }

    static void djikstra() {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        vis[x] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] dx = {now, -1, 1};

            for (int i = 0; i < 3; i++) {
                int nx = now + dx[i];

                if (nx >= 0 && nx <= 100000) {
                    int time = vis[now];
                    if (i >= 1) {
                        time += 1;
                    }

                    if (time < vis[nx]) {
                        vis[nx] = time;
                        q.add(nx);
                    }
                }
            }
        }
    }
}
