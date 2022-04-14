import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        // 데이터 입력
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 순회하며 가능한 경우 dfs
        ArrayList<Integer> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 1의 값을 가지고, 방문하지 않았다면 dfs 수행
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    group.add(cnt); // 개수 세서 리스트에 넣기
                }
            }
        }

        // 오름차순 출력을 위한 정렬
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for (int i : group) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int row, int col) {
        cnt++;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];

            if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= n) continue; // 인덱스 벗어나지 않는지?
            if (map[nRow][nCol] == 0) continue; // 갈 수 있는 칸인지?
            if (visited[nRow][nCol]) continue; // 방문한 곳인지?

            dfs(nRow, nCol);
        }
    }
}