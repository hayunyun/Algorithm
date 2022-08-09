import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int kyuWin, kyuLose;
	static int[] kyu, in, ans = new int[9];
	static boolean[] visited = new boolean[9];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			kyu = new int[9];
			boolean[] check = new boolean[19]; // 1~18
			
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				check[kyu[i]] = true;
			}
			
			// 인영이 카드 기록
			in = new int[9];
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (!check[i]) {
					in[idx++] = i;
				}
			}
			
      kyuWin = 0; kyuLose = 0;
			inYoungWay(0);
			System.out.printf("#%d %d %d\n", t, kyuWin, kyuLose);
		}
	}
	
	static void inYoungWay(int cnt) {	
		if (cnt == 9) {
			int kyuScore = 0, inScore = 0;
			for (int j = 0; j < 9; j++) {
				if (kyu[j] > ans[j]) {
					kyuScore += kyu[j] + ans[j];
				}
				else if (ans[j] > kyu[j]) {
					inScore += kyu[j] + ans[j];
				}
			}
			
			if (kyuScore > inScore) kyuWin++;
			else if (inScore > kyuScore) kyuLose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[cnt] = in[i];		
				inYoungWay(cnt + 1);
				visited[i] = false;
			}
		}
		
	}

}