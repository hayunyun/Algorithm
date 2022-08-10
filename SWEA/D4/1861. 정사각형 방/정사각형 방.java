import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static int[][] map;
	static int n;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <=  tc; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			
			// input
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			int maxIdx = Integer.MAX_VALUE;
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cur = bfs(i, j);
					if (max < cur) {
						max = cur;
						maxIdx = map[i][j];
					}
					else if (max == cur) {
						maxIdx = Math.min(maxIdx, map[i][j]);
					}
				}
			}
			
			System.out.printf("#%d %d %d\n", t, maxIdx, max);
		}
	}
	
	static int bfs(int i, int j) {
		int total = 1;
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {i, j});
		
		while(!q.isEmpty()) {	
			int[] now = q.poll();
			int r = now[0]; int c = now[1];
			int nowVal = map[r][c];
			
			for (int z = 0; z < 4; z++) {
				int nr = r + dr[z];
				int nc = c + dc[z];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (map[nr][nc] - nowVal == 1) {
						q.add(new int[] {nr, nc});
						total++;
					}
				}
			}
		}
		
		return total;
	}

}
