import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
     *** 우선순위큐 사용
	 * 1. 먹을 수 있는 물고기 탐색 (자신보다 크기가 작은 물고기 탐색) -> 어레이리스트에 담는다
	 * 2. 
	 * - 먹을 수 있는 물고기가 1마리면 -> 먹으러 감
	 * - 먹을 수 있는 물고기가 여러 마리면 -> 가장 가까운 물고기를 먹으러 감
	 * 2-1. 가까운 물고기 탐색 과정
	 * 	- 어레이리스트의 물고기 하나하나 BFS로 접근해서 거리 기록
	 *  - 기록된 물고기들을 거리 -> 행 -> 열 순으로 정렬
	 *  - 맨 앞에 있는 것으로 이동해서, 물고기를 먹는다
	 * 3. 먹다가 먹은 횟수가 크기만큼 되면, 크기 레벨업
	 * 
	 * 먹을 수 있는 물고기가 없을 때까지 1-3 반복
	 * 
	 * 우선순위큐 사용
	 */
	static class Fish implements Comparable<Fish> {
		int r, c, num; // 물고기는 거리, 상어는 크기
		
		public Fish(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Fish(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.num == o.num) {
				if (this.r == o.r) {
					return this.c - o.c;
				}
				return this.r - o.r;
			}
			return this.num - o.num;
		}
	}
	static int n, time, sharkEat;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static PriorityQueue<Fish> fishes = new PriorityQueue<>();
	static Fish shark;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 9) {
        			shark = new Fish(i, j, 2);
        			map[i][j] = 0;
        		}
        	}
        }
        
        process();
        System.out.println(time);
	}
	
	static void process() {
		while (true) {
			// 먹을 수 있는 물고기를 가져온다
			fishes.clear();
			calDist();	
			
			if (fishes.isEmpty()) return; // 먹을 수 있는 물고기가 없으면 과정 종료
			
			Fish f = fishes.poll(); // 정렬 후, 가장 우선순위가 높은 물고기를 먹는다
			
			// 상어가 f의 위치로 이동하고, f를 먹는다. 
			shark.r = f.r;
			shark.c = f.c;
			map[f.r][f.c] = 0;
			time += f.num;
			
			// 먹은 횟수가 상어의 크기와 같아지면, 초기화하고 상어의 크기를 키운다
			if (++sharkEat == shark.num) { 
				sharkEat = 0;
				shark.num += 1;
			}
		}
	}
	
	// 먹을 수 있는 물고기들의 거리 계산
	static void calDist() {
		boolean[][] vis;
		vis = new boolean[n][n];
		
		Queue<Fish> q = new LinkedList<>();
		q.add(new Fish(shark.r, shark.c, 0));
		vis[shark.r][shark.c] = true;
		
		while (!q.isEmpty()) {
			Fish now = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					// 방문하지 않았고, 물고기의 크기가 상어의 크기보다 작거나 같으면 이동 가능
					if (!vis[nr][nc] && map[nr][nc] <= shark.num) {
						vis[nr][nc] = true;
						q.add(new Fish(nr, nc, now.num + 1));
						// 물고기의 크기가 상어의 크기보다 작으면 이동 가능
						if (map[nr][nc] > 0 && map[nr][nc] < shark.num) {
							fishes.add(new Fish(nr, nc, now.num + 1));
						}
					}
					
				}
			}
		}
	}
}
