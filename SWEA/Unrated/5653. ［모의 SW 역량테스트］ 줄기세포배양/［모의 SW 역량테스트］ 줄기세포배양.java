import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int n, m, k, num;
    static PriorityQueue<Cell> cells;
    static boolean[][] vis;
    static class Cell implements Comparable<Cell> {
        int r, c, x, time; // 행, 열, 생명력 수치, 시간(1씩 감소하고, 0이 되면 번식함)

        @Override
        public String toString() {
            return "Cell{" +
                    "r=" + r +
                    ", c=" + c +
                    ", x=" + x +
                    ", time=" + time +
                    '}';
        }

        public Cell(int r, int c, int x, int time) {
            this.r = r;
            this.c = c;
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Cell o) {
            if (this.time == o.time) {
                return o.x - this.x;
            }
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            num = 400;
            vis = new boolean[num][num];
            cells = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x != 0) {
                        cells.add(new Cell(i+num/2, j+num/2, x, x));
                        vis[i+num/2][j+num/2] = true;
                    }
                }
            }
            
            process(k);
            sb.append("#" + tc + " " + cells.size() + "\n");
        }
        System.out.println(sb);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static void process(int time) {
        for (int i = 0; i < time; i++) {
            ArrayList<Cell> tmp = new ArrayList<>();
            for (int j = cells.size(); j > 0; j--) {
                Cell ce = cells.poll();
                if (ce.time > 0) {
                    ce.time--;
                    tmp.add(ce);
                } else {
                    if (ce.time == 0) {
                        for (int d = 0; d < 4; d++) {
                            int nr = ce.r + dr[d];
                            int nc = ce.c + dc[d];

                            if (!vis[nr][nc]) {
                                vis[nr][nc] = true;
                                tmp.add(new Cell(nr, nc, ce.x, ce.x));
                            }
                        }
                    }
                    ce.time--;
                    if (ce.time * (-1) < ce.x) tmp.add(ce);
                }
            }

            for (int j = 0; j < tmp.size(); j++) {
                Cell ce = tmp.get(j);
                cells.add(ce);
            }
        }
    }
}
