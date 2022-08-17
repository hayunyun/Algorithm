import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> [] graph = new ArrayList[n + 1];
        int[] vis = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int a = Integer.parseInt(st.nextToken());
        	 int b = Integer.parseInt(st.nextToken());
        	 
        	 graph[a].add(b);
        	 graph[b].add(a);
        }
        
        // 오름차순 정렬
        for (int i = 1; i <= n; i++) {
        	Collections.sort(graph[i]);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        vis[start] = cnt++; 
        
        while (!q.isEmpty()) {
        	int now = q.poll();
        	
        	
        	for (int near : graph[now]) {
        		if (vis[near] == 0) {
        			q.add(near);
        			vis[near] = cnt++; 
        		}
        	}
        }
        
        
        for (int i = 1; i <= n; i++) {
        	System.out.println(vis[i]);
        }
        
	}

}
