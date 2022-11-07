import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent, rank;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        rank = new int[n+1];
        parent = new int[n+1];
        makeSet();
        
        for (int tc = 1; tc <= m; tc++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	calc(x, a, b);
        }
        
        System.out.println(sb);
	}
	
	private static void calc(int x, int a, int b) {
		if (x == 0) {
			union(a, b);
		} else {
			if (findSet(a) == findSet(b)) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
	}

	static void makeSet() {
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = findSet(parent[a]);
	}
	
	static void union(int a, int b) {
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
}
