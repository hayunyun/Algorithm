import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < n; j++) {
        		map[i][j] = str.charAt(j) - '0';
        	}
        }

        check(0, 0, n);
        System.out.println(sb);
	}
	
	static void check(int r, int c, int size) {
		// 전체 0 또는 전체 1인지 확인
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}
		
		if (sum == size * size) {
			sb.append(1);
		} else if (sum == 0) {
			sb.append(0);
		} else { // 섞여있다면 재귀
			sb.append("(");
			check(r, c, size / 2);
			check(r, c + size / 2, size / 2);
			check(r + size / 2, c, size / 2);
			check(r + size / 2, c + size /2 , size / 2);
			sb.append(")");
		}
		
	}

}
