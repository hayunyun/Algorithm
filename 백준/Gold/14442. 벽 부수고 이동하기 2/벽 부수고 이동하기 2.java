import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int[][][] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		vis = new int[k+1][n][m];
		System.out.println(go());
	}
	
	/*
	 * 0. 방문하지 않았다면
	 * 1. 벽이 아닐 경우
	 * -> 그냥 지나간다 (+1)
	 * 2. 벽일 경우
	 * 2-1-1. 벽을 부수지 않은 경우 벽을 부순다
	 * 2-1-2. 벽을 k번 이하 부순 경우 벽을 부순다
	 * 2-2. 벽을 k번 초과로 부순 경우 더이상 벽을 부술 수 없다 (지나갈 수 없다) -> 코드구현 필요 x
	 */
	
	static int go() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});
		vis[0][0][0] = 1;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int cnt = now[0];
			int r = now[1];
			int c = now[2];
			
			if (r == n-1 && c == m-1) return vis[cnt][r][c];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					// 벽이 아님 && 방문안함
					if (map[nr][nc] == 0 && vis[cnt][nr][nc] == 0) {
						vis[cnt][nr][nc] = vis[cnt][r][c] + 1;
						q.add(new int[] {cnt, nr, nc});
					}
					// 벽 && 부실수있음 && 부신경우 방문안함
					else if (map[nr][nc] == 1 && cnt < k && vis[cnt+1][nr][nc] == 0){
						vis[cnt + 1][nr][nc] = vis[cnt][r][c] + 1;
						q.add(new int[] {cnt+1, nr, nc});
					}
					
				}
			}
		}
		
		return -1;
	}

}
