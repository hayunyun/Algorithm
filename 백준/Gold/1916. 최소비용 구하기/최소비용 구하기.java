import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int to, cost;

        public Info(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Info>[] buss = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            buss[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            buss[a].add(new Info(b, c));
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        boolean[] vis = new boolean[n+1];
        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        costs[start] = 0;

        for (int i = 1; i <= n; i++) {
            // 방문하지 않은 정점 중 가장 가중치가 적은 것 선택
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && costs[j] < min) {
                    min = costs[j];
                    minIdx = j;
                }
            }

            if (minIdx == end) {
                break;
            }

            vis[minIdx] = true;

            // 해당 정점중 기록된 값보다 현재 경유값이 더 적으면 갱신
            for (int j = 0; j < buss[minIdx].size(); j++) {
                Info now = buss[minIdx].get(j);

                if (!vis[now.to] && costs[now.to] > min + now.cost) {
                    costs[now.to] = min + now.cost;
                }
            }
        }

        System.out.println(costs[end]);
    }
}
