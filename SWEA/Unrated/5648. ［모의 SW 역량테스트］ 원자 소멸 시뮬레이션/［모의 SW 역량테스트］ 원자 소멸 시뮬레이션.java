import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Atom {
        int r, c, d, e;

        public Atom(int r, int c, int d, int e) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
    static Queue<Atom> atoms;
    static int n, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map = new int[4002][4002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            atoms = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int r = 4000 - (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                map[r][c] = e;
                atoms.add(new Atom(r, c, d, e));
            }

            ans = 0;
            bfs();
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!atoms.isEmpty()) {
            Atom a = atoms.poll();
            // 한 자리에 여러개의 원자가 있다면
            if (map[a.r][a.c] != a.e) {
                ans += map[a.r][a.c]; // 현재 에너지양 모두 더하고
                map[a.r][a.c] = 0; // 소멸
                continue;
            }

            // 소멸하지 않았다면, 이동한다
            int nr = a.r + dr[a.d];
            int nc = a.c + dc[a.d];
            // 범위를 벗어나면 영영 만나지 않는다 -> 추가 안해도됨
            // 범위 안이면 새로운 곳으로 이동
            // 큐를 통해 선입선출로 알아서 충돌 이후 처리가 잘 됨
            if (nr >= 0 && nr <= 4000 && nc >= 0 && nc <= 4000) {
                if (map[nr][nc] == 0) {
                    map[nr][nc] = a.e;
                    atoms.add(new Atom(nr, nc, a.d, a.e));
                } else {
                    map[nr][nc] += a.e;
                }
            }
            map[a.r][a.c] = 0;
        }
    }
}
