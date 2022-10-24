import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    /*
    1. 빈칸이 아닌 뿌요일 경우, 상하좌우 탐색
    2. 4개 이상 모인 경우, 터진다 -> 전체 다 담아놓고, 동시에 터지기 && cnt++
    3. 터진 뿌요의 열들을 맨위부터 내려오며 스택에 넣고, 땅에 닿으면 pop하며 쌓기
    4. 다시 1-3 반복
    5. cnt 출력
     */
    static class Puyo {
        int r, c;
        char color;

        public Puyo(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map = new char[12][6];
    static boolean[][] vis;
    static ArrayList<ArrayList<Puyo>> puyos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        while (true) {
            if (!game()) break;
        }

        System.out.println(cnt);
    }

    static boolean game() {
        vis = new boolean[12][6];
        puyos = new ArrayList<>();

        // 뿌요 탐색
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.' && !vis[i][j]) {
                    findPuyo(i, j);
                }
            }
        }

        if (puyos.isEmpty()) return false; // 터질 뿌요가 없으면 연쇄 끝

        // 4개 이상인 뿌요들은 터진다 (동시에)
        boolean[] cols = new boolean[6];
        for (ArrayList<Puyo> ps : puyos) {
            for (Puyo puyo : ps) {
                map[puyo.r][puyo.c] = '.';
                cols[puyo.c] = true;
            }
        }

        cnt++; // 연쇄++

        // 터진 블록들은 밑으로 내려온다
        for (int i = 0; i < 6; i++) {
            if (cols[i]) {
                Stack<Character> tmp = new Stack<>();
                for (int j = 0; j < 12; j++) {
                    if (map[j][i] != '.') {
                        tmp.push(map[j][i]);
                        map[j][i] = '.';
                    }
                }

                int nowRow = 11;
                while (!tmp.isEmpty()) {
                    map[nowRow--][i] = tmp.pop();
                }
            }
        }

        return true;
    }

    static void findPuyo(int r, int c) {
        ArrayList<Puyo> tmp = new ArrayList<>();
        tmp.add(new Puyo(r, c, map[r][c]));

        Queue<Puyo> q = new LinkedList<>();
        q.add(new Puyo(r, c, map[r][c]));
        vis[r][c] = true;

        while (!q.isEmpty()) {
            Puyo puyo = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = puyo.r + dr[d];
                int nc = puyo.c + dc[d];

                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6) {
                    if (!vis[nr][nc] && puyo.color == map[nr][nc]) {
                        vis[nr][nc] = true;
                        q.add(new Puyo(nr, nc, map[nr][nc]));
                        tmp.add(new Puyo(nr, nc, map[nr][nc]));
                    }
                }
            }
        }

        if (tmp.size() >= 4) {
            puyos.add(tmp);
        }
    }
}
