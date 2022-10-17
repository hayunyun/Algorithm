import java.util.*;

class Solution {
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static List<List<Integer>> ans;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        
        map = heights;
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfs(i, j);
            }
        }
        
        return ans;
    }
    
    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        boolean[] check = new boolean[2];
        
        q.add(new int[] {r, c});
        vis[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == 0 || now[1] == 0) {
                check[0] = true;
            }
            
            if (now[0] == n-1 ||now[1] == m-1) {
                check[1] = true;
            }
            
            if (isOk(check)) {
                List<Integer> arr = new ArrayList<>();
                arr.add(r);
                arr.add(c);
                ans.add(arr);
                return;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!vis[nr][nc] && map[nr][nc] <= map[now[0]][now[1]]) {
                        q.add(new int[] {nr, nc});
                        vis[nr][nc] = true;   
                    }
                }
            }
        }
    }
    
    static boolean isOk(boolean[] check) {
        for (int i = 0; i < 2; i++) {
            if (!check[i]) return false;
        }
        
        return true;
    }
}
