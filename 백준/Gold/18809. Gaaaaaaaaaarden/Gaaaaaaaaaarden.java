import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
     * 1. 배양액 뿌리기 : 빨강조합 -> 남은것중 초록조합
     * 2. 퍼져나간다
     * 2-1. 호수가 아닌 경우에만 퍼져나갈 수 있다
     * 2-2-1. 배양액이 안퍼진 곳이면, 퍼져나간다. (큐에 넣어준다)
     * 2-2-2. 배양액이 퍼진 곳이면
     *          다음곳에 퍼진게 red이고, 현재배양액이 green이고, 퍼진 시점이 같다면 -> 꽃으로 변한다. (큐에 넣지 않는다)
     *          다음곳에 퍼진게 green이고, 현재배양액이 red이고, 퍼진 시점이 같다면 -> 꽃으로 변한다. (큐에 넣지 않는다)
     * 3. 다 퍼져나간 후 꽃의 개수 세고, 최댓값 갱신
     */
    static class Land {
        int r, c;

        public Land(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Info {
        int time, type;

        public Info(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    static int r, c, green, red, maxFlower;
    static int[][] map;
    static ArrayList<Land> goodLand = new ArrayList<>();
    static boolean[] vis; // 조합 섞이지 않게 체크
    static int[] reds, greens; // 빨강조합, 초록조합
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int RED = 3;
    static final int GREEN = 4;
    static final int FLOWER = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        green = Integer.parseInt(st.nextToken());
        red = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goodLand.add(new Land(i, j));
                }
            }
        }

        // 배양액을 뿌릴 수 있는 땅에서 r개의 조합 구하고, 남은 것 중 g개의 조합 구한다
        reds = new int[red];
        greens = new int[green];
        vis = new boolean[goodLand.size()];

        maxFlower = Integer.MIN_VALUE;
        redCombi(0, 0);
        System.out.println(maxFlower);
    }

    // 빨강조합
    static void redCombi(int idx, int cnt) {
        if (cnt == red) {
            greenCombi(0, 0);
            return;
        }

        for (int i = idx; i < goodLand.size(); i++) {
            vis[i] = true;
            reds[cnt] = i;
            redCombi(i + 1, cnt + 1);
            vis[i] = false;
        }
    }

    // 초록조합
    static void greenCombi(int idx, int cnt) {
        if (cnt == green) {
            bfs();
            return;
        }

        for (int i = idx; i < goodLand.size(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                greens[cnt] = i;
                greenCombi(i + 1, cnt + 1);
                vis[i] = false;
            }
        }
    }

    private static void bfs() {
        // 맵에 초록, 빨강 배양액을 뿌린다
        Queue<Land> q = new LinkedList<>();
        Info[][] infos = new Info[r][c];
        int flowers = 0;

        for (int i = 0; i < red; i++) {
            Land redLand= goodLand.get(reds[i]);
            infos[redLand.r][redLand.c] = new Info(0, RED);
            q.add(new Land(redLand.r, redLand.c));
        }

        for (int i = 0; i < green; i++) {
            Land greenLand= goodLand.get(greens[i]);
            infos[greenLand.r][greenLand.c] = new Info(0, GREEN);
            q.add(new Land(greenLand.r, greenLand.c));
        }

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Land now = q.poll();
                Info info = infos[now.r][now.c];

                if (info.type == FLOWER) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                        // 호수가 아닐 경우 퍼질 수 있다
                        if (map[nr][nc] != 0) {
                            if (infos[nr][nc] == null) { // 아직 배양액이 뿌려지지 않은 곳이면
                                infos[nr][nc] = new Info(info.time + 1, info.type);
                                q.add(new Land(nr, nc));
                            // 다음곳이 red, 현재가 green이고 퍼져나간 시간이 같다면
                            } else if (infos[nr][nc].type == RED && info.type == GREEN && infos[nr][nc].time == info.time + 1) {
                                infos[nr][nc].type = FLOWER;
                                flowers++;
                            // 다음곳이 green, 현재가 red이고 퍼져나간 시간이 같다면
                            } else if (infos[nr][nc].type == GREEN && info.type == RED && infos[nr][nc].time == info.time + 1) {
                                infos[nr][nc].type = FLOWER;
                                flowers++;
                            }
                        }
                    }
                }
            }
        }
        maxFlower = Math.max(maxFlower, flowers); // 꽃 최대개수 갱신
    }
}