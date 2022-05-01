import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] cnt;
    static int[] way = {0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = new int[100001];

        if (n == k) System.out.println(0);
        else {
            bfs(n);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        cnt[x] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now - 1;
                else if (i == 1) next = now + 1;
                else next = now * 2;
                
                if (next == k) {
                    System.out.println(cnt[now]);
                    return;
                }

                if (next >= 0 && next < cnt.length && cnt[next] == 0) {
                    q.add(next);
                    cnt[next] = cnt[now] + 1;
                }
            }
        }
    }
}