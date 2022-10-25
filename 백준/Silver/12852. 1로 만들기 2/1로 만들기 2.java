import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int[] cnt = new int[1000001]; // 최소 연산 횟수 기록
    static int[] parent = new int[1000001]; // 도착지서부터 역추적
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Arrays.fill(parent, Integer.MAX_VALUE);
        calc(n);
    }

    private static void calc(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(cnt[1] - 1).append("\n");

                Stack<Integer> st = new Stack<>();
                while (true) {
                    st.push(now);
                    if (now == n) break;
                    now = parent[now];
                }

                while (!st.isEmpty()) {
                    sb.append(st.pop()).append(" ");
                }
                System.out.println(sb);
                return;
            }

            // 가장 먼저 도달한 경우가 가장 최소연산 -> 연산이 일어나지 않은경우에만 연산한다
            if (now % 3 == 0 && now / 3 >= 1) {
                if (cnt[now / 3] == 0) {
                    q.add(now/3);
                    parent[now/3] = now;
                    cnt[now/3] = cnt[now] + 1;
                }
            }

            if (now % 2 == 0 && now / 2 >= 1) {
                if (cnt[now / 2] == 0) {
                    q.add(now / 2);
                    parent[now / 2] = now;
                    cnt[now / 2] = cnt[now] + 1;
                }
            }

            if (now - 1 >= 1) {
                if (cnt[now-1] == 0) {
                    q.add(now - 1);
                    parent[now - 1] = now;
                    cnt[now - 1] = cnt[now] + 1;
                }
            }
        }
    }
}
