import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, cycle;
	static boolean[] vis;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	n = Integer.parseInt(br.readLine());
        	graph = new ArrayList[n+1];
        	for (int i = 1; i <= n; i++) {
        		graph[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= n; i++) {
        		int to = Integer.parseInt(st.nextToken());
        		graph[i].add(to);
        	}
        	
        	cycle = 0;
        	vis = new boolean[n+1];
        	for (int i = 1; i <= n; i++) {
        		if (!vis[i]) {
        			dfs(i);
        			cycle++;
        		}
        	}
        	
        	sb.append(cycle).append("\n");
        }
        System.out.println(sb);
	}
    
	private static void dfs(int node) {
		if (vis[node]) return;
		
		vis[node] = true;
		dfs(graph[node].get(0));
	}
}
