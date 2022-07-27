import java.io.*;
import java.util.*;

class Position {
	int z, y, x;
	
	public Position(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static int n, m, h;
	static int[][][] map;
	static boolean[][][] visited;
	static Queue<Position> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][m][n];
		
		// input
		for (int i = 0; i < h; i++) {
			for (int j = 0;  j < m; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) q.add(new Position(i, j, k));
				}
			}
		}
		
		System.out.print(bfs());

	}
	
	static int bfs() {
		// 육방탐색
		int[] dz = {1, -1, 0, 0, 0, 0}; // 위아래
		int[] dy = {0, 0, 1, -1, 0, 0}; // 앞뒤
		int[] dx = {0, 0, 0, 0, -1, 1}; // 좌우
		
		while (!q.isEmpty()) {
			Position now = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int nz = now.z + dz[i];
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				
				// 범위 안이면
				if (nz >= 0 && nz < h && ny >= 0 && ny < m && nx >= 0 && nx < n) {
					// 방문하지 않았고, 0인 곳으로 퍼져나가기
					if (map[nz][ny][nx] == 0) {
						map[nz][ny][nx] = map[now.z][now.y][now.x] + 1;
						q.add(new Position (nz, ny, nx));
					}
				}
			}

		}
		
		
		// 모두 수행하고 나서 
		// 처음부터 모든 토마토가 익어있는 상태라면 0 출력
		// 하나라도 0이 있으면 -1 출력
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < h; i++) {
			for (int j = 0;  j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (map[i][j][k] == 0) return -1;
					max = Math.max(max, map[i][j][k]);
				}
			}
		}
		
		if (max == 1) return 0;
		
		return max - 1;
	}

}
