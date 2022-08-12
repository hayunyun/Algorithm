import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] vis;
	static int max, n, cnt;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			vis = new boolean[n][n];
			cnt = 0;
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			eat();
	
			System.out.printf("#%d %d\n", tc, max);

		}
	}

	// 요정이 치즈 먹음
	static void eat() {
		for (int d = 0; d <= 100; d++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == d) {
						map[i][j] = -1;
					}
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != -1 && !vis[i][j]) {
						cnt++;
//						countBfs(i, j);
						countDfs(i, j);
					}
				}
			}
			
			
			max = Math.max(max, cnt);
			cnt = 0;
			// 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					vis[i][j] = false;
				}
			}
		}
		
	}
	
	// 치즈덩어리 세기 - BFS
	static void countBfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {row, col});
		vis[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (map[nr][nc] != -1 && !vis[nr][nc]) {
						vis[nr][nc] = true;
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	// 치즈덩어리 세기 - DFS
	// 완탐이기 때문에 basis part가 필요 없다
	static void countDfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				if (map[nr][nc] != -1 && !vis[nr][nc]) {
					vis[nr][nc] = true;
					countDfs(nr, nc);
				}
			}
		}
	}
}