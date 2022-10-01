import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Cell {
        int cnt, dir;

        public Cell(int cnt, int dir) {
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "{" +
                    "cnt=" + cnt +
                    ", dir=" + dir +
                    '}';
        }
    }
    static int n, m, k;
    // 상하좌우
    // 0->1, 1->0
    // 2->3, 3->2
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Cell>[][] map;

    // 모서리 : 0 또는 n-1 이 포함된 행/열 -> (0,0~n-1), (0~n-1, 0), (n-1, 0~n-1), (0~n-1, n-1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new ArrayList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[r][c].add(new Cell(cnt, dir));
            }
            move(m);
            sb.append("#").append(tc).append(" ").append(getSum()).append("\n");
        }
        System.out.println(sb);

    }

    static void move(int time) {
        for (int t = 0; t < time; t++) {
            ArrayList<Cell>[][] tmp = new ArrayList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!map[i][j].isEmpty()) {
                        for (int l = 0; l < map[i][j].size(); l++) {
                            Cell c = map[i][j].get(l);
                            int nr = i + dr[c.dir];
                            int nc = j + dc[c.dir];
                            if (nr == 0 || nc == 0 || nr == n - 1 || nc == n - 1) {
                                c.cnt /= 2;
                                if (c.cnt == 0) continue;
                                c.dir += 1;
                                if (c.dir % 2 == 0) c.dir -= 2;
                            }
                            tmp[nr][nc].add(c);
                        }
                    }
                }
            }

            // 이동 완료 후, 기존 맵에 저장
            map = tmp;
            // 마친 후, 사이즈가 1개 초과면 합치기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j].size() > 1) {
                        int[] res = combine(map[i][j]);
                        map[i][j].clear();
                        map[i][j].add(new Cell(res[0], res[1]));
                    }
                }
            }
        }
    }

    // 여러개 셀 합치기
    static int[] combine(ArrayList<Cell> arr) {
        int maxIdx = -1;
        int maxCnt = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < arr.size(); i++) {
            Cell c = arr.get(i);
            total += c.cnt;
            if (c.cnt > maxCnt) {
                maxIdx = i;
                maxCnt = c.cnt;
            }
        }
        return new int[] {total, arr.get(maxIdx).dir}; // cnt, dir
    }

    static int getSum() {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Cell c : map[i][j]) {
                    total += c.cnt;
                }
            }
        }
        return total;
    }
}
