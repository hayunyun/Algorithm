import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0, -2, -2, 2, 2, -1, 1, -1, 1}; // 상하 / 상2 상2 하2 하2 / 상1 하1 상1 하1
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1, -2, -2, 2, 2}; // 좌우 / 좌1 우1 좌1 우1 / 좌2 좌2 우2 우2
    
    static class Pos {
        int r, c, hCnt;

        public Pos(int r, int c, int hCnt) {
            this.r = r;
            this.c = c;
            this.hCnt = hCnt; // 말만큼 몇번이나 행동했는지
        }
    }

    static int w, h, k;
    static int[][] map;
    static int[][][] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        k = Integer.parseInt(br.readLine()); // 말만큼 k번 행동
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        cnt = new int[h][w][k+1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 원숭이는 (0,0)에서 (w-1, h-1)까지 가야함
        // 말만큼은 k번만 행동, 그 이후로는 사방탐색만 가능
        // 벽부수고 넘어가기 에서 벽부시는 1번 -> k번으로!
        // 원숭이 동작 수의 최솟값 구하기

        System.out.println(monkey(new Pos(0, 0, 0)));
    }

    static int monkey(Pos p) {
        Queue<Pos> q = new LinkedList<>();
        q.add(p);

        while (!q.isEmpty()) {
            Pos now = q.poll();
            int r = now.r;
            int c = now.c;
            int hCnt = now.hCnt;

            if (r == h - 1 && c == w - 1) {
                return cnt[r][c][hCnt];
            }

            int time = hCnt < k ? 12 : 4;

            for (int i = 0; i < time; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 안인지
                if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
                    // 갈 수 있는 곳인지 && 방문하지 않은 곳인지
                    if (map[nr][nc] == 0) {
                        // 원숭이 이동
                        if (i < 4 && cnt[nr][nc][hCnt] == 0) {
                            cnt[nr][nc][hCnt] = cnt[r][c][hCnt] + 1;
                            q.add(new Pos(nr, nc, hCnt));
                        }
                        // 말처럼 이동
                        else if (i >= 4 && cnt[nr][nc][hCnt + 1] == 0) {
                            cnt[nr][nc][hCnt + 1] = cnt[r][c][hCnt] + 1;
                            q.add(new Pos(nr, nc, hCnt + 1));
                        }
                    }
                }
            }

        }

        return -1;
    }
}