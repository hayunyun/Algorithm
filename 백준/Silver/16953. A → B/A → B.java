import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        long val;
        int cnt;

        public Info(long val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    static int a, b;
    static boolean[] vis = new boolean[1000000001];
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

//        System.out.println(a + " " + b);
        bfs();
    }

    static void bfs() {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(a, 1));
        vis[a] = true;

        while (!q.isEmpty()) {
            Info now = q.poll();
            long val = now.val;
            int cnt = now.cnt;

            if (val == b) {
                System.out.println(cnt);
                return;
            }

            long nVal = 0;
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case 0:
                        nVal = val * 2;
                        break;
                    case 1:
                        nVal = val * 10 + 1;
                        break;
                }

                if (nVal <= 1000000000) {
                    if (!vis[(int)nVal]) {
                        vis[(int)nVal] = true;
                        q.add(new Info(nVal, cnt + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
