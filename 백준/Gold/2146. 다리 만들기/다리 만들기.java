import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, country = 1, ans;
	static int[][] map;
	static boolean[][] vis;
	/*
	 * 1. 대륙 구분 -> bfs로 0이 아닌 곳 모두 탐색, country 지정 (bfs)
	 * 2. 대륙 연결 -> 0이 아니고, 서로 숫자가 다른 두 대륙 연결 (bfs)
	 */
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (!vis[i][j] && map[i][j] != 0) {
        			findCtry(i, j);
        		}
        	}
        }
        
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (map[i][j] > 0) {
        			bridge(i, j);
        		}
        	}
        }
        
        System.out.println(ans);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	/*
	 * 현재 대륙과 다른 번호의 대륙을 찾을 때까지 bfs
	 * 가장 먼저 찾는 경우가 최단 경로이므로 바로 빠져나오면 된다
	 */
	static class Brdg {
		int r, c, length;
		
		public Brdg(int r, int c, int length) {
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}
	
	static void bridge(int r, int c) {
		vis = new boolean[n][n];
		Queue<Brdg> q = new LinkedList<>();
		q.add(new Brdg(r, c, 0));
		vis[r][c] = true;
		int nowCtry = map[r][c];
		
		while (!q.isEmpty()) {
			Brdg b = q.poll();
						
			for (int d = 0; d < 4; d++) {
				int nr = b.r + dr[d];
				int nc = b.c + dc[d];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (!vis[nr][nc]) {
						if (map[nr][nc] == 0) {
							q.add(new Brdg(nr, nc, b.length + 1));
							vis[nr][nc] = true;
						} else if (map[nr][nc] > nowCtry) {
							ans = Math.min(ans, b.length);
							return;
						}
					}
				}
			}
		}
	}
	
	static void findCtry(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		vis[r][c] = true;
		map[r][c] = country;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (!vis[nr][nc] && map[nr][nc] != 0) {
						q.add(new int[] {nr, nc});
						vis[nr][nc] = true;
						map[nr][nc] = country;
					}
				}
			}
		}
		
		country++;
	}
}
