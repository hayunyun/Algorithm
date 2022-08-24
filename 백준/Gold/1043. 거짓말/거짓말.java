import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, rank, trueP;
    static int[][] parties;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        rank = new int[n+1];

        makeSet();

        st = new StringTokenizer(br.readLine());
        int trues = Integer.parseInt(st.nextToken());
        
        trueP = new int[trues];
        for (int i = 0; i < trues; i++) {
            trueP[i] = Integer.parseInt(st.nextToken());
        }

        // 진실 아는 사람끼리 부모 같도록 연결
        for (int i = 0; i < trues - 1; i++) {
            union(trueP[i] , trueP[i+1]);
        }

        // 각 파티마다 오는 사람들 기록
        parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            parties[i] = new int[num];

            // 파티 하나씩 기록
            for (int j = 0; j < num; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }

            // 파티 안의 사람들 union
            for (int j = 0; j < num - 1; j++) {
                union(parties[i][j], parties[i][j + 1]);
            }
        }

        int trueParent = -1;
        if (trueP.length > 0) {
            trueParent = findSet(trueP[0]);
        }

        int ans = m;
        for (int i = 0; i < m; i++) {
            if (findSet(parties[i][0]) == trueParent) ans--;
        }

        System.out.println(ans);
    }

    static void makeSet() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            if (rank[px] == rank[py]) rank[px]++;
        }
    }
}
