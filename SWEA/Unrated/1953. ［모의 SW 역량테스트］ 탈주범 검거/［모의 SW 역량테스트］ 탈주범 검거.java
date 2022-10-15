import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] dirs = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	static int[][] possibleDir = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {1, 2}, {0, 2}, {0, 3}, {1, 3}};
	static class Node {
		int r, c, dir;
		
		public Node(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	
        	map = new int[n][m];
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < m; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	vis = new boolean[n][m];
        	bfs(r, c, l);
        	
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			if (vis[i][j]) cnt++;
        		}
        	}

        	sb.append("#" + tc + " " + cnt + "\n");
        }
        System.out.println(sb);
	}
	
	private static void bfs(int r, int c, int l) {
		Queue<Node> q = new LinkedList<>();
		int[] nowD = dirs[map[r][c]];
		for (int i = 0; i < nowD.length; i++) {
			q.add(new Node(r, c, nowD[i]));
		}
		vis[r][c] = true;
		int curTime = 0;
		
        if (l == 1) return;
		while(!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				Node now = q.poll();

				int[] dir = dirs[map[now.r][now.c]];
				for (int j = 0; j < dir.length; j++) {
					int d = dir[j];
					
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
						if (!vis[nr][nc] && map[nr][nc] != 0 && isPossible(nr, nc, d)) {
							q.add(new Node(nr, nc, d));
							vis[nr][nc] = true;
						}
					}
				}					
			}
			
			if (++curTime == l - 1) break;
		}
	}
	
	static boolean isPossible(int r, int c, int dir) {
		int[] pDir = possibleDir[map[r][c]];
		for (int j = 0; j < pDir.length; j++) {
			if (dir == pDir[j]) {
				return true;
			}
		}
		return false;
	}
}
