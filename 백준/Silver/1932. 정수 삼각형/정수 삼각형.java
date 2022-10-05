import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] triangle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		triangle = new int[n][];
		
		for (int i = 0; i < n; i++) {
			triangle[i] = new int[i+1];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				if (j == 0) {
					triangle[i][j] += triangle[i-1][j];
				} else if (j == i) {
					triangle[i][j] += triangle[i-1][j-1];
				} else {
					triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, triangle[n-1][i]);
		}
		System.out.println(max);
	}
}
