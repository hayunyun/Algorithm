import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] time = new int[100001]; // 해당 부분에 가장 최단시간이 기록됨
    static int[] parent = new int[100001]; // 해당 부분에 도착하기 전 위치
    
    // 한번 방문한 곳은 다시 방문할 필요가 없다 (처음 방문한 경우가 가장 최단경로)
    // 즉, 한 도착지로 이동한 출발지는 딱 하나이다
    // 즉, 도착지로 이동하기 전 출발지를 기록하고, k에 도착하면 역순으로 거슬러 출력한다
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
    }

    static int[] move = {-1, 1, 0};
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                // 도착지부터 경로를 역순으로 출력 -> 스택 사용
                Stack<Integer> route = new Stack<>();
                while (true) {
                    route.push(now);
                    if (now == n) break;
                    now = parent[now];
                }

                StringBuilder sb = new StringBuilder();
                sb.append(time[k]).append("\n");
                while (!route.isEmpty()) {
                    sb.append(route.pop()).append(" ");
                }
                System.out.println(sb);
                return;
            }

            for (int d = 0; d < 3; d++) {
                int nextNode = now + move[d];

                if (nextNode == now) nextNode *= 2;

                if (nextNode >= 0 && nextNode <= 100000) {
                    if (time[nextNode] == 0) {
                        time[nextNode] = time[now] + 1;
                        q.add(nextNode);
                        parent[nextNode] = now;
                    }
                }
            }
        }
    }
}
