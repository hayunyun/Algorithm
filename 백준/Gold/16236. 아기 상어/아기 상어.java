import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int r, c, dist;

        public Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        public int compareTo(Fish o) {
            // 0. 거리가 가까운 것부터
            if (this.dist == o.dist) {
                    // 1. 가장 위쪽 (row 비교)
                    if (this.r == o.r) {
                        // 2. 가장 왼쪽 (col 비교)
                        return this.c - o.c;
                    }
                    return this.r - o.r;
            }
            return this.dist - o.dist;
        }
    }

    static int n, ans, size = 2, eatCnt = 0; // ans: 상어의 시간 저장
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    static int[][] map;
    static Fish shk;
    static ArrayList<Fish> fishes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shk = new Fish(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        babyShark();
        System.out.println(ans);

    }

    static void babyShark() {
        Queue<Fish> shark = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        shark.add(shk);
        vis[shk.r][shk.c] = true;

        while (true) {
            while (!shark.isEmpty()) {
                // 1. BFS를 통해 현재 위치에서 먹을 수 있는 물고기 탐색 (자신보다 크기 작은 것) && 거리 기록
                Fish now = shark.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                        // 이동 가능
                        if (map[nr][nc] <= size) {
                            shark.add(new Fish(nr, nc, now.dist + 1));
                            vis[nr][nc] = true;

                            // 먹기 가능
                            if (map[nr][nc] >= 1 && map[nr][nc] < size) {
                                fishes.add(new Fish(nr, nc, now.dist + 1));
                            }
                        }
                    }
                }
            }

            // 거리 순 나열
            if (!fishes.isEmpty()) {
                eat();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        vis[i][j] = false;
                    }
                }
                shark.add(shk);
            } else return;
        }
    }

    static void eat() {
        // 2. 물고기 중 거리 재서 가장 가까운 거 먹기
        Collections.sort(fishes);

        Fish f = fishes.get(0);

        // 먹기
        shk.r = f.r;
        shk.c = f.c;
        ans += f.dist;
        map[f.r][f.c] = 0;

        if (++eatCnt == size) {
            size++;
            eatCnt = 0;
        }

        fishes.clear();
    }
}