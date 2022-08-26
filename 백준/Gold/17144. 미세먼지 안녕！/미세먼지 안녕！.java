import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 공기청정기는 항상 1번 열에 있으며 크기는 두 행 차지
	 * 
	 * 1. 미세먼지 확산 (미세먼지가 있는 모든 칸에서 동시에 일어남)
	 * - 네 방향으로 확산되고, 인접한 방향에 공기청정기가 있거나 칸이 없으면 거긴 안일어남
	 * - 확산되는 양은 미세먼지/5
	 * - 기존 위치에 남은 미세먼지의 양은 미세먼지 - (미세먼지/5)*확산된 방향 개수
	 * 
	 * 2. 공기청정기 작동
	 * - 위쪽 공기청정기는 반시계방향 순환
	 * - 아래쪽 공기청정기는 시계방향 순환
	 * - 바람 불면 미세먼지가 방향의 바람대로 한칸씩 이동
	 * 
	 * t초가 지난 후, 방에 남아있는 미세먼지의 양 출력!
	 */
	static int r, c, t, ms = -1, time;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0}; // 우하좌상
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c]; 
        for (int i = 0; i < r; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < c; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == -1) {
        			if (ms == -1) ms = i;
        		}
        	}
        }
        
        
        for (int time = 0; time < t; time++) {
        	dust();      
        	revClock(0, 0, ms, c - 1);
        	airClock(ms+1, 0, r - 1, c - 1);        	
        }
        
        int sum = 0;
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		sum += map[i][j];
        	}
        }
        
        System.out.println(sum + 2);
	}
	
	static void dust() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		if (map[i][j] != 0) {
        			q.add(new int[] {i, j});
        		}
        	}
        }
		
		int[][] tmp = new int[r][c];
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if ((nr == ms && nc == 0) || (nr == ms + 1 && nc == 0)) continue;
					tmp[nr][nc] += map[row][col] / 5;
					cnt++;						
				}
			}
			tmp[row][col] -= map[row][col] / 5 * cnt; 
		}
		
		for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		map[i][j] += tmp[i][j];
        	}
        }
		
	}
	
	static void revClock(int startR, int startC, int endR, int endC) {
		// 0행 ~ ms 행까지 반시계 -> 시계방향으로 돌며 값 옮기기 // 우하좌상
		int tmp = map[startR][startC];
		
		// 우
		for (int i = 0; i < endC; i++) {
			map[startR][i] = map[startR][i + 1];
		}
		
		// 하
		for (int i = startR; i < endR; i++) {
			map[i][endC] = map[i + 1][endC];
		}
		
		// 좌
		for (int i = endC; i > 1; i--) {
			map[endR][i] = map[endR][i - 1];
		}
		
		// 상
		for (int i = endR - 1; i > 0; i--) {
			map[i][startC] = map[i - 1][startC];
		}
		
		map[endR][1] = 0;
		map[startR + 1][startC] = tmp;
	}
	
	
	static void airClock(int startR, int startC, int endR, int endC) {
		// (ms + 1) ~ (c - 1) 행까지 시계 -> 반시계방향으로 돌며 값 옮기기 // 좌하우상 (2103)
		int tmp = map[startR][endC];
		
		// 좌
		for (int i = endC; i > 1; i--) {
			map[startR][i] = map[startR][i - 1];
		}

		// 하
		for (int i = startR + 1; i < endR; i++) {
			map[i][startC] = map[i + 1][startC];
		}
		
		// 우
		for (int i = 0; i < endC; i++) {
			map[endR][i] = map[endR][i + 1];
		}
		
		// 상
		for (int i = endR; i > startR; i--) {
			map[i][endC] = map[i - 1][endC];
		}
		
		map[startR][1] = 0;
		map[startR + 1][endC] = tmp;
	}

}
