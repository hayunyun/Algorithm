import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 상 하 좌 우 좌상 좌하 우상 우하 상좌 상우 하좌 하우
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1, -2, -2, 2, 2};
	static int[] dc = {0, 0, -1, 1, -2, -2, 2, 2, -1, 1, -1, 1}; 
	
	static int k, w, h;
	static int[][] map;
	static int[][][] vis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		vis = new int[k+1][h][w];
		System.out.println(move());
	}
	
	/*
	 * 장애물이 아닐 경우 이동할 수 있다
	 * 1. 원숭이 이동
	 * 2. 말 이동
	 */
	
	static int move() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int cnt = now[0];
			int r = now[1];
			int c = now[2];
			
			if (r == h-1 && c == w-1) {
				return vis[cnt][r][c];
			}
			
			int idx = (cnt < k) ? 12 : 4;
			for (int i = 0; i < idx; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
					if (map[nr][nc] == 0) {
						// 1. 원숭이 이동
						if (i < 4 && vis[cnt][nr][nc] == 0) {
							vis[cnt][nr][nc] = vis[cnt][r][c] + 1;
							q.add(new int[] {cnt, nr, nc});
						}
						// 2. 말 이돟
						if (i >= 4 && vis[cnt+1][nr][nc] == 0) {
							vis[cnt+1][nr][nc] = vis[cnt][r][c] + 1;
							q.add(new int[] {cnt+1, nr, nc});
						}
					}
				}
			}
		}
		
		return -1;
	}
}
