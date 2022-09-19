import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int k, n, f;
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken()); // k명의 학생 소풍보낼것
        n = Integer.parseInt(st.nextToken()); // 1 ~ n 친구수
        f = Integer.parseInt(st.nextToken()); // f개의 친구관계

        graph = new ArrayList[n+1];
        vis = new boolean[n+1];
        sel = new int[k];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (graph[i].size() >= k - 1) {
                vis[i] = true;
                sel[0] = i;
                picnic(1, i);
                vis[i] = false;
            }
        }

        System.out.println(-1);
    }

    static void picnic(int cnt, int node) {
        if (cnt == k) {
            for (int i = 0; i < k; i++) {
                sb.append(sel[i]).append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        for (int nd : graph[node]) {
            if (!vis[nd] && isFriend(nd, cnt)) {
                vis[nd] = true;
                sel[cnt] = nd;
                // 새로 추가된 데이터가 지금까지의 데이터들과 친구가 맞다면
                picnic(cnt + 1, nd);
                vis[nd] = false;
            }
        }
    }

    static boolean isFriend(int node, int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (!graph[node].contains(sel[i])) return false;
        }

        return true;
    }
}
