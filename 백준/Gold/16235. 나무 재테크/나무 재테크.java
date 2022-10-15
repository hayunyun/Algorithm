import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Land {
        int power;
        Deque<Integer> trees;

        public Land(int power) {
            this.power = power;
            trees = new LinkedList<>();
        }

    }
    static int n, m, k;
    static int[][] info;
    static Land[][] map;
    // 좌상 상 우상 좌 우 좌하 하 우하
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // k년 진행

        map = new Land[n+1][n+1];
        info = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = new Land(5);
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[x][y].trees.add(z);
        }

        for (int i = 1; i <= k; i++) {
            season();
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!map[i][j].trees.isEmpty()) {
                    total += map[i][j].trees.size();
                }
            }
        }
        System.out.println(total);
    }

    static void season() {
        ArrayList<int[]> breedTrees = new ArrayList<>();

        // 봄 & 여름
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Deque<Integer> tmp = new LinkedList<>();
                Land land = map[i][j];
                int deadAge = 0;
                while (!land.trees.isEmpty()) {
                    int age = land.trees.poll();
                    if (map[i][j].power >= age) {
                        map[i][j].power -= age;
                        age++;
                        if (age % 5 == 0) {
                            breedTrees.add(new int[] {i, j});
                        }
                        tmp.add(age);
                    } else {
                        deadAge += age/2;
                    }
                }
                map[i][j].trees = tmp;

                // 여름
                map[i][j].power += deadAge;
            }
        }


        // 가을
        for (int[] now : breedTrees) {
            for (int i = 0; i < 8; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
                    map[nr][nc].trees.addFirst(1);
                }
            }
        }

        // 겨울
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j].power += info[i][j];
            }
        }
    }
}
