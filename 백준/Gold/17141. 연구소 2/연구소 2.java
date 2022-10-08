import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, time;
	static int[][] map;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<int[]> virus = new ArrayList<>();
	static int[][] sel;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스의 수
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 2) {
        			virus.add(new int[] {i, j});
        			map[i][j] = 0;
        		}
        	}
        }
        
        sel = new int[m][1];
        time = INF;
        combi(0, 0);
        System.out.println(time == INF ? -1 : time);
	}
	
	// 바이러스 놓기 -> 조합
	static void combi(int idx, int cnt) {
		if (cnt == m) {
			// 시간 구하고, 최솟값 갱신
			int cur = spread();
			time = Math.min(time, cur);
			return;
		}
		
		for (int i = idx; i < virus.size(); i++) {
			int[] v = virus.get(i);
			sel[cnt] = new int[] {v[0], v[1]};
			combi(i + 1, cnt + 1);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int spread() {
		// 2인 곳에서 동시에 퍼진다
		Queue<int[]> q = new LinkedList<>();
		int[][] newMap = new int[n][n];
		for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		newMap[i][j] = map[i][j];
        	}
        }
		
		for (int i = 0; i < m; i++) {
			int r = sel[i][0];
			int c = sel[i][1];
			q.add(new int[] {r, c});
			newMap[r][c] = 2;
		}
		
		int total = 0;
		while (!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				int[] now = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = now[0] + dr[d];
					int nc = now[1] + dc[d];
					
					if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
						if (newMap[nr][nc] == 0) {
							q.add(new int[] {nr, nc});
							newMap[nr][nc] = 3;
						}
					}
				}
			}
			total++;
		}
		
		if (!check(newMap)) return INF;
		return total - 1;
	}
	
	static boolean check(int[][] mp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mp[i][j] == 0) return false;
			}
		}
		return true;
	}
}
