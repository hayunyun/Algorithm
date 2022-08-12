import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n , min = Integer.MAX_VALUE, sum = 0;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chick = new ArrayList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); // 최대 m개의 치킨집을 고르고, 나머지는 전부 폐업
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		if (num == 1) house.add(new int[] {i, j});
        		else if (num == 2) chick.add(new int[] {i, j});
        	}
        }
        
       
        int[][] sel = new int[m][2];
        recursive(chick, sel, 0, 0);
        System.out.println(min);
 
	}
	
	private static void recursive(ArrayList<int[]> ch, int[][] sel, int idx, int k) {
		if (k == sel.length) {
			// TODO 각 집과 치킨집의 거리 구하기
			sum = 0;
			for (int j = 0; j < house.size(); j++) {
				int dist = Integer.MAX_VALUE;
				for (int i = 0; i < sel.length; i++) {
					dist = Math.min(dist, Math.abs(house.get(j)[0] - sel[i][0]) + Math.abs(house.get(j)[1] - sel[i][1]));
				}
				sum += dist;
			}
			
			min = Math.min(min, sum);
			
			return;
		}
		
		for (int i = idx; i < ch.size(); i++) {
			sel[k] = ch.get(i);
			recursive(ch, sel, i + 1, k + 1);
		}
		
	}

}
