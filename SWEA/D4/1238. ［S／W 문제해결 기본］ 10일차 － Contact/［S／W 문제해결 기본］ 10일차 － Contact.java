import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	// 가장 마지막에 연락을 받는 사람 중 번호가 가장 큰 사람 구하기
	static ArrayList<Integer>[] people;
	static int[] check;
	static int ans, cnt = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int len = Integer.parseInt(st.nextToken());
        	int start = Integer.parseInt(st.nextToken());
        	
        	check = new int[101];
        	ans = Integer.MIN_VALUE;
        	people = new ArrayList[101];
        	
        	for (int i = 1; i <= 100; i++) {
        		people[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < len / 2; i++) {
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		
        		if (!people[from].contains(to)) {
        			people[from].add(to);        		
        		}
        	}
        	        	
        	bfs(start);
        	for (int i = 1; i <= 100; i++) {
        		if (check[i] == cnt - 1) {
        			ans = Math.max(ans, i);
        		}
        	}
        	
        	sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);

	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		check[node] = 1;
		
		
		while (!q.isEmpty()) {
			for (int j = q.size() - 1; j >= 0; j--) {
				int now = q.poll();
				
				for (int i = 0; i < people[now].size(); i++) {
					int person = people[now].get(i);
					
					if (check[person] == 0) {
						check[person] = cnt + 1;
						q.add(person); 
					}
				}
			}
			cnt++;
			
		}
	}

}
