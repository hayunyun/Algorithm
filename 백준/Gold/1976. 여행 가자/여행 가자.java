import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] routes, parent, rank;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine()); // 계획 도시 수

        routes = new int[m];
        parent = new int[n+1];
        rank = new int[n+1];

        makeSet();

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 1) {
                    union(i, j);
                }
            }
        }

        // 여행계획
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            routes[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 0; i < m - 1; i++) {
            if (findSet(routes[i]) != findSet(routes[i + 1])) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }


    private static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);

        if (pa == pb) return;

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
            if (rank[pa] == rank[pb]) {
                rank[pa]++;
            }
        }
    }

    private static int findSet(int a) {
        if (parent[a] == a) return a;

        return parent[a] = findSet(parent[a]);
    }

    private static void makeSet() {
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }
}
