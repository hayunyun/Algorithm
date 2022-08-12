import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	static int n, min;
	static int[][] ns;
	static int[] com, home;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1;  t<= T; t++) {
			n = sc.nextInt();
			// 회사 -> 고객 -> 집 최단거리
			// 회사 좌표, 집 좌표, n명의 좌표
			
			com = new int[2];
			home = new int[2];
			ns = new int[n][2];
			
			com[0] = sc.nextInt();
			com[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			for (int i = 0; i < n; i++) {
				ns[i][0] = sc.nextInt();
				ns[i][1] = sc.nextInt();
			}
			
			int[][] join = new int[n][2];
			boolean[] vis = new boolean[n];
			min = Integer.MAX_VALUE;
			recursive(0, join, vis);
			System.out.printf("#%d %d\n", t, min);
		}
	}
	
	// 순열
	static void recursive(int cnt, int[][] join, boolean[] v) {
		if (cnt == n) {
			// 회사 -> 고객 -> 집 최단거리
			int sum = 0;
			sum += Math.abs(com[0] - join[0][0]) + Math.abs(com[1] - join[0][1]);
			for (int i = 1; i < n; i++) {
				sum += Math.abs(join[i-1][0] - join[i][0]) + Math.abs(join[i-1][1] - join[i][1]);
			}
			sum += Math.abs(join[n-1][0] - home[0]) + Math.abs(join[n-1][1] - home[1]);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				join[cnt] = ns[i];
				recursive(cnt + 1, join, v);
				v[i] = false;
			}
			
		}
	}

}
