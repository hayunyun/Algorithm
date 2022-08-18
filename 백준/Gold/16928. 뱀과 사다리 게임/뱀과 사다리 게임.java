import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class PosCnt {
        int pos, cnt;

        public PosCnt(int p, int c) {
            pos = p;
            cnt = c;
        }
    }

    static int[] info;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        info = new int[101]; // 뱀, 사다리 정보 저장
        vis = new boolean[101]; // 방문체크

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info[from] = to;
        }

        game();
    }

    static void game() {
        Queue<PosCnt> q = new LinkedList<>();
        q.add(new PosCnt(1, 0));
        vis[1] = true;

        while (!q.isEmpty()) {
            PosCnt now = q.poll();
            int nowP = now.pos;
            int nowC = now.cnt;

            for (int i = 1; i <= 6; i++) {
                int next = nowP + i;

                if (next == 100) {
                    System.out.println(nowC + 1);
                    return;
                }

                if (next >= 1 && next <= 100) {
                    if (!vis[next]) {
                        if (info[next] != 0) {
                            next = info[next];
                        }
                        vis[next] = true;
                        q.add(new PosCnt(next, nowC + 1));
                    }
                }
            }
        }
    }
}
