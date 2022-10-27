import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * done: 이미 탐색이 끝난 경우 true
     * vis: 한 번 방문한 경우 true
     
     1. done[i] = true인 경우: 탐색이 끝나 더 볼 필요가 없다.
     2. done[i] = false인 경우: 탐색 필요
     2-1. vis[i] = false인 경우: 아직 방문하지 않음. 계속해서 dfs
     2-2. vis[i] = true인 경우: 방문했던 곳을 재방문 -> 싸이클임. 
                               싸이클 수 더해주고 done[i] = true로 바꿔줌.
                               계속해서 안쪽까지 dfs
	 */
	static int n, start, cnt;
	static int[] nums;
	static boolean[] vis, done; // vis: 한 번 방문함, done: 검사가 끝나 더이상 들어갈 필요 X
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	n = Integer.parseInt(br.readLine());
        	nums = new int[n+1];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= n; i++) {
        		nums[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	cnt = 0; // 싸이클 구성원 수
        	done = new boolean[n+1];
        	vis = new boolean[n+1];
        	for (int i = 1; i <= n; i++) {
        		if (!done[i]) {
        			if (nums[i] == i) {
        				done[i] = true;
        				cnt++;
        			} else {
        				findTeam(i);
        			}
        		}
        	}
        	
        	sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
	}
	
	static void findTeam(int now) {
		if (done[now]) return; // 탐색끝난곳이면 return
		
		if (vis[now]) { // 이미 방문했던 곳에 다시 방문한다면 싸이클임
			cnt++;
			done[now] = true; // 이제 이곳은 더이상 탐색할 필요가 없다
		}
		
		vis[now] = true; // 방문체크
		int next = nums[now];
		
		findTeam(next);
		
		done[next] = true; // 싸이클이 아닌것도 검사는 끝났으므로 true 체크
		vis[now] = false; // 방문체크 초기화
	}
	
}
