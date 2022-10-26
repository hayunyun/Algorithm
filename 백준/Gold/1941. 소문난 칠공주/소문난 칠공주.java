import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*
    1. 25명의 학생 중 7명 뽑기 (중간에 도연이가 4개 이상 되면 가지치기) -> 조합
    2. 7명이 인접한지 확인 -> BFS
     */
    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int ans;
    static Info[] sel = new Info[7];
    static char[][] map = new char[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0, 0);
        System.out.println(ans);
    }

    static void combination(int idx, int cnt, int dasom, int doyeon) {
        if (doyeon > 3) return; // 도연이가 3명을 넘으면 더이상 탐색할 필요 없음

        if (cnt == 7) {
            // 다솜이가 4명 이상이고, 7개가 인접한지 확인
            if (dasom >= 4 && isNear()) {
                ans++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;

            sel[cnt] = new Info(row, col);
            if (map[row][col] == 'S') {
                combination(i+1, cnt+1, dasom+1, doyeon); // 다솜
            } else { 
                combination(i+1, cnt+1, dasom, doyeon+1); // 도연
            }
        }
    }

    // 7개가 서로 인접한지 체크
    static boolean isNear() {
        boolean[] vis = new boolean[7];
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(sel[0].r, sel[0].c));
        vis[0] = true;

        while (!q.isEmpty()) {
            Info now = q.poll();

            for (int i = 0; i < 7; i++) {
                if (!vis[i]) { // 방문하지 않았고
                    Info next = sel[i];
                    if (Math.abs(now.r - next.r) + Math.abs(now.c - next.c) == 1) { // 인접하다면
                        q.add(next);
                        vis[i] = true;
                    }
                }
            }
        }

        // 일곱명 모두 방문했다면, 일곱명은 인접하다
        for (int i = 0; i < 7; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }
}
