import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans, start;
	static int[][] map;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken()); // i -> j
        	}
        }
        
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	start = i;
        	vis = new boolean[n];
        	vis[i] = true;
        	go(i, 0, 0);
        }
        
        System.out.println(ans);
        
	}
	
	// 0->1->2->3->0
	static void go(int node, int cnt, int sum) {	
		if (cnt == n - 1) {
			// 시작점으로 돌아가기
			if (map[node][start] == 0) return;
			sum += map[node][start];
			// 최솟값 갱신
			ans = Math.min(ans, sum);
			return;
		}
		
		// i -> j == 0이면 진행하지 않는다
		for (int i = 0; i < n; i++) {
			if (!vis[i] && map[node][i] != 0) {
				vis[i] = true;
				go(i, cnt + 1, sum + map[node][i]);
				vis[i] = false;
			}
		}
	}

}
