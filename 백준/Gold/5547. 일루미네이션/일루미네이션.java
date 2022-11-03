import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
     * 1. 원소가 1일 때 탐색
     *     - 홀수 : (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c), (r+1, c+1)
     *     - 짝수 : (r-1, c-1), (r-1, c), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c)
     * 2. 각 원소마다 인접한 1 개수 기록해두기
     * 3. (1,1)에서 원소가 1일때까지 탐색하고 닿으면 큐에 넣지않고 넘어간다 (치즈 문제)
     * 4. 방문하지 못한 곳과 인접한 곳을 체크하면서 인접개수 더해준다
     * 5. 방문체크 되어있고, 1인 곳만 돌면서 (6-인접개수)를 총합에 더해준다
     */
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int c, r;
    static int[][] map;
    static int[][] near;
    static int[] dr = {-1, -1, 0, 0, 1, 1};
    static int[][] dc = {{0, 1, -1, 1, 0, 1}, {-1, 0, -1, 1, -1, 0}} ; // 홀수,짝수
    static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[r+2][c+2];
        ArrayList<Node> ones = new ArrayList<>();
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) ones.add(new Node(i, j));
            }
        }

//        print();

        // 각 원소마다 인접한 건물 개수 카운트
        near = new int[r+2][c+2];
        vis = new boolean[r+2][c+2];
        for (Node node : ones) {
            int row = node.row;
            int col = node.col;

            if (!vis[row][col]) {
                nearCount(node);
            }
        }

//        print(near);


//        for (int i = 1; i <= r; i++) {
//            for (int j = 1; j <= c; j++) {
//                if (vis[i][j]) System.out.print("* ");
//                else System.out.print(". ");
//            }
//            System.out.println();
//        }
//        System.out.println("---------------------");

        bfs(new Node(0, 0));

//        for (int i = 1; i <= r; i++) {
//            for (int j = 1; j <= c; j++) {
//                if (vis[i][j]) System.out.print("* ");
//                else System.out.print(". ");
//            }
//            System.out.println();
//        }
//        System.out.println("---------------------");


        for (int i = 1; i <= r+1; i++) {
            for (int j = 1; j <= c+1; j++) {
                if (!vis[i][j]) {
                    nearCount(new Node(i, j));
                }
            }
        }

//        print(near);

        int ans = 0;
        for (int i = 1; i <= r+1; i++) {
            for (int j = 1; j <= c+1; j++) {
                if (vis[i][j] && map[i][j] == 1) {
                    ans += (6 - near[i][j]);
                }
            }
        }

        System.out.println(ans);

//        bfs(new Node(0, 0));
    }

    static void bfs(Node node) {
        // 0이면 계속 더하기
        // 1이면 더하지 않고 넘어간다
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node now = q.poll();
            int cPos;
            if (now.row % 2 != 0) cPos = 0;
            else cPos = 1;

            for (int i = 0; i < 6; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[cPos][i];

                if (nr >= 0 && nr <= r+1 && nc >= 0 && nc <= c+1) {
//                    System.out.println(nr + " " + nc);
                    if (!vis[nr][nc]) {
//                        System.out.println(nr + " " + nc);
                        vis[nr][nc] = true;
                        q.add(new Node(nr, nc));
                    }
                }
            }
        }
    }

    static void nearCount(Node node) {
        int row = node.row, col = node.col;
        int cPos;
        if (row % 2 != 0) cPos = 0;
        else cPos = 1;

        for (int d = 0; d < 6; d++) {
            int nr = row + dr[d];
            int nc = col + dc[cPos][d];

            if (nr >= 1 && nr <= r+1 && nc >= 1 && nc <= c+1) {
                if (map[nr][nc] == 1) {
                    near[nr][nc]++;
                }
            }
        }

        vis[row][col] = true;
    }

    static void print(int[][] map) {
        for (int i = 1; i <= r+1; i++) {
            for (int j = 1; j <= c+1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}