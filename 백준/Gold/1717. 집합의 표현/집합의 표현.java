import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1]; // 0 ~ n
        rank = new int[n+1];
        makeSet();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int met = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (met == 0) {
                union(a,b);
            } else {
                if (findSet(a) == findSet(b)) {
                    sb.append("YES");
                } else sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);

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
