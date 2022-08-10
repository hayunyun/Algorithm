import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map, ans;
	// 시계방향으로 돌며 한칸씩 땡기기 (반대방향)
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		int min = Math.min(n, m) / 2;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// r번 회전
		for (int i = 0; i < r; i++) {
			// 돌리는 횟수 : 큰거, 작은거 중에 작은거 / 2
			for (int j = 0; j < min; j++) {
				int dir = 0;
				int row = j, col = j;
				int tmp = map[row][col];
				
				while(dir < 4) {
					int nRow = row + dr[dir];
					int nCol = col + dc[dir];
					
					if (nRow >= j && nRow < n - j && nCol >= j && nCol < m - j) {
						map[row][col] = map[nRow][nCol];
						row = nRow;
						col = nCol;
					}
					else dir++;
				}
				map[j+1][j] = tmp;					
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
