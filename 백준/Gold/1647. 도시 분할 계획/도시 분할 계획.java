import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Line {
        int from, to, weight;

        public Line(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int n, m, cnt, ans;
    static Line[] lines;
    static int[] parents, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lines = new Line[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a, b, c);
        }

        Arrays.sort(lines, Comparator.comparingInt(o -> o.weight));

        rank = new int[n+1];
        parents = new int[n+1];
        makeSet();

        // Kruskal
        kruskal();
        System.out.println(ans);
    }

    static void kruskal() {
        // cnt가 n-1개가 될때까지 반복
        // 가중치가 적은 간선부터 선택하며, 싸이클이 형성되면 패스
        for (int i = 0; i < m; i++) {
            if (cnt == n - 1) {
                return;
            }

            Line l = lines[i];

            if (findSet(l.from) == findSet(l.to)) continue;

            union(l.from, l.to);
            cnt++;
            if (cnt < n - 1) {
                ans += l.weight;
            }
        }

    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (parents[x] == x) return x;

        return parents[x] = findSet(parents[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parents[py] = px;
        } else {
            parents[px] = py;
            if (rank[px] == rank[py]) rank[px]++;
        }
    }
}
