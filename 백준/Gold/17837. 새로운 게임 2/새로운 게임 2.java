import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
	    이동하려는 칸이
	    흰색 칸 - 그 칸으로 이동. 말이 있으면 가장 위에 a 올림
	            - a 위에 다른 말도 있으면 함께 이동
	    빨간색 칸 - 이동한 말의 순서를 반대로 바꿔서 올림 (1)
	    파란색 칸 - a 이동방향 반대로 하고 한 칸 이동. 반대칸도 파란색이면 가마니 (2)
	
	    한 칸에 말이 4개 이상 쌓이는 경우? 게임종료 -> 몇번째 턴인지 출력
      1000보다 크거나 게임 종료안되면 -1
     */
    static class Cell {
        int color;
        List<Integer> arr;

        public Cell(int color) {
            this.color = color;
            arr = new ArrayList<>();
        }
    }

    static class Marker {
        int num, r, c, dir;

        public Marker(int r, int c, int num, int dir) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
        }
    }
    static int n, k;
    static Cell[][] map;
    static ArrayList<Marker> markers;
    // 우좌상하 (0~3)
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int color = Integer.parseInt(st.nextToken());
                map[i][j] = new Cell(color);
            }
        }

        markers = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            map[r][c].arr.add(j);
            markers.add(new Marker(r, c, j, dir));
        }

        game();
    }

    static void game() {
        int turn = 0;
        boolean flag = false;
        while (!flag && turn <= 1000) {
            // 1~k 말 이동
            for (Marker m : markers) {

                int nr = m.r + dr[m.dir];
                int nc = m.c + dc[m.dir];
                int ndir = m.dir;

                // 다음 색깔이 파란색 || 벽에 닿으면 반대방향으로 전환
                if (nr >= n || nr < 0 || nc >= n || nc < 0 || map[nr][nc].color == 2) {
                    if (m.dir % 2 == 0) {
                        ndir += 1;
                    } else {
                        ndir -= 1;
                    }

                    nr = m.r + dr[ndir];
                    nc = m.c + dc[ndir];
                    
                    m.dir = ndir; // 이동못해도 방향은 바뀜
                    // 반대방향도 벽이거나 막혀있으면 파랑이면 움직이지 않는다
                    if (nr >= n || nr < 0 || nc >= n || nc < 0 || map[nr][nc].color == 2) continue; 
                }
                
                // 본인 위에 있는건 싹다 가져감
                int idx = map[m.r][m.c].arr.indexOf(m.num);
                int size = map[m.r][m.c].arr.size();

                // 현재 말부터 위까지 덱에 넣는다
                Deque<Integer> deque = new LinkedList<>();
                for (int i = idx; i < size; i++) {
                    deque.add(map[m.r][m.c].arr.get(idx));
                    map[m.r][m.c].arr.remove(idx);
                }

                if (map[nr][nc].color == 0) { // 다음 칸이 흰색이면 그대로 쌓기
                    while (!deque.isEmpty()) {
                        int now = deque.pollFirst();
                        markers.get(now).r = nr;
                        markers.get(now).c = nc;
                        map[nr][nc].arr.add(now);
                    }
                } else if (map[nr][nc].color == 1) { // 빨간색이면 반대로 쌓기
                    while (!deque.isEmpty()) {
                        int now = deque.pollLast();
                        markers.get(now).r = nr;
                        markers.get(now).c = nc;
                        map[nr][nc].arr.add(now);
                    }
                }

                if (map[nr][nc].arr.size() >= 4) {
                    flag = true;
                    break;
                }

                m.r = nr;
                m.c = nc;
            }

            turn++;
        }

        System.out.println(turn > 1000 ? -1 : turn);
    }
}