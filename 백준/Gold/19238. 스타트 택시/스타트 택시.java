import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Info implements Comparable<Info> {
		int r, c, dist, fuel;
		boolean isOver;
		
		public Info(int r, int c) {
			this.r = r;
			this.c = c;
			this.dist = -1;
		}
		
		public Info(int r, int c, int dist, int fuel) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Info o) {
			if (this.dist == o.dist) {
				if (this.r == o.r) {
					return this.c - o.c;					
				}
				return this.r - o.r;
			}
			return this.dist - o.dist;
		}
	}
	
	// 칸 수, 승객 수, 연료, 택시r, 택시c, 태운 승객 수
	static int n, m, k, tR, tC, customerCnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Info[] arrPos;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); 

        arrPos = new Info[m+1];
        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) map[i][j] = -1;
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        tR = Integer.parseInt(st.nextToken());
        tC = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int departR = Integer.parseInt(st.nextToken());
        	int departC = Integer.parseInt(st.nextToken());
        	int arriveR = Integer.parseInt(st.nextToken());
        	int arriveC = Integer.parseInt(st.nextToken());
        	
        	map[departR][departC] = i;
        	arrPos[i] = new Info(arriveR, arriveC);
        }
        
        process();
        System.out.println(k);
	}
	
	private static void process() {
		// 승객을 다 태울때까지 진행
		while (customerCnt < m) {
			// 1. 현재 택시의 위치에서, 남은 승객 중 가장 가까운 승객의 위치를 구한다
			int target = findTarget();
			
			if (target == -1) { // 연료 부족 시 종료
				k = -1;
				return;
			} else  { 
				// 2. 현재 태운 승객의 목적지로 운전
				if (!goDestination(target)) { // 연료 부족 시 종료
					k = -1;
					return;
				}
			} 
		}
	}
	
	static boolean goDestination(int num) {
		boolean[][] vis = new boolean[n+1][n+1]; 
		Queue<Info> q = new LinkedList<>(); // BFS를 위한 큐
		q.add(new Info(tR, tC, 0, k));
		Info dest = arrPos[num];
		
		while (!q.isEmpty()) {
			Info now = q.poll();
			
			if (now.r == dest.r && now.c == dest.c) {
				dest.dist = now.dist;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
					if (!vis[nr][nc] && map[nr][nc] != -1 && now.fuel > 0) {
						vis[nr][nc] = true;
						q.add(new Info(nr, nc, now.dist + 1, now.fuel - 1));
					}
				}
			}
		}
		
		// 목적지에 데려다 줄 수 있는가?
		if (dest.dist != -1 && dest.dist <= k) {
			k += dest.dist;
			tR = dest.r;
			tC = dest.c;
			
			arrPos[num].isOver = true;
			customerCnt++;
		} else {
			return false;
		}
		
		return true;
	}
	
	// 태우러 갈 수 있고, 가장 우선순위가 높은 고객 가져옴
	static int findTarget() {
		
		// 모든 고객의 우선순위 순으로 저장
		PriorityQueue<Info> pq = new PriorityQueue<>();
		
		boolean[][] vis = new boolean[n+1][n+1];
		Queue<Info> q = new LinkedList<>(); // BFS를 위한 큐
		q.add(new Info(tR, tC, 0, k));
		while (!q.isEmpty()) {
			Info now = q.poll();
			
			if (map[now.r][now.c] > 0 && !arrPos[map[now.r][now.c]].isOver) {
				pq.add(new Info(now.r, now.c, now.dist, now.fuel));
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];
				
				if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
					if (!vis[nr][nc] && map[nr][nc] != -1 && now.fuel > 0) {
						vis[nr][nc] = true;
						q.add(new Info(nr, nc, now.dist + 1, now.fuel - 1));
					}
				}
			}
		}
		
		int target = -1;
		if (!pq.isEmpty()) { // 우선순위가 높은 고객 꺼냄
			Info info = pq.poll();
			
			// 태우러 갈 수 있는가?
			if (info.dist <= k) {
				// 태우러 감
				tR = info.r;
				tC = info.c;
				k -= info.dist;
				
				target = map[info.r][info.c];
			}
		}
		return target;
	}
}

