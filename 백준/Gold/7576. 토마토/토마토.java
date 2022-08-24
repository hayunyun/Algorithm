import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, days;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for (int j = 0; j < m; j++) {
    		   map[i][j] = Integer.parseInt(st.nextToken());
    		   if (map[i][j] == 1) q.add(new int[] {i, j});
    	   }
        }
        
        days = 0;
        BFS();
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			for (int j = q.size() - 1; j >= 0; j--) {
				int[] now = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];
					
					if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
						if (map[nr][nc] == 0) {
							map[nr][nc] = 1;
							q.add(new int[] {nr, nc});
						}
					}
				}				
			}
			days++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(days - 1);
	}

}
