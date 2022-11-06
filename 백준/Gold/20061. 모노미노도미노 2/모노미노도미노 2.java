import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /*
    1. 블럭 쌓기 (경계에 닿을 때까지 초록/파랑 각각 이동)
    2. 한줄에 4개 모이면 터지고, 터진 줄의 개수만큼 블럭 이동
    3. 연한 칸에 블럭이 있는지 판단하고, 존재하는 줄의 개수만큼 블럭 이동
     */
    static final int SIZE = 10;
    static int score = 0;
    static int[][] map = new int[SIZE][SIZE];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 1: 1X1, 2: 1X2, 3:2X1
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            game(t, r, c);
        }

        System.out.println(score);
        System.out.println(cntTile());
    }

    private static void game(int t, int r, int c) {
        // 1. 블럭 쌓기
        // map[r][c] == 0이 아닐 때까지 계속 하강 (초록, 파랑)
        stacked(t, r, c);

        // 2. 초록 / 파랑 각각 진한 부분에 한줄 쌓였다면 터지고, 쌓이기
        boom();

        // 3. 연한 칸에 블록이 있는지 색깔별 판단
        specialTile();
    }

    // 1. 블럭 쌓기
    // map[r][c] == 0이 아닐 때까지 계속 하강 (초록, 파랑)
    private static void stacked(int t, int r, int c) {
        int nr = r, nc = c;
        switch (t) {
            case 1:
                // 초록
                while (nr < SIZE && map[nr][nc] == 0) {
                    nr++;
                }
                map[nr-1][nc] = 1;

                // 파랑
                nr = r;
                while (nc < SIZE && map[nr][nc] == 0) {
                    nc++;
                }
                map[nr][nc-1] = 1;
                break;
            case 2:
                // 초록
                while (nr < SIZE && map[nr][nc] == 0 && map[nr][nc+1] == 0) {
                    nr++;
                }
                map[nr-1][nc] = 1;
                map[nr-1][nc+1] = 1;

                // 파랑
                nr = r;
                while (nc < SIZE && map[nr][nc] == 0) {
                    nc++;
                }

                map[nr][nc-1] = 1;
                map[nr][nc-2] = 1;
                break;
            case 3:
                // 초록
                while (nr < SIZE && map[nr][nc] == 0) {
                    nr++;
                }
                map[nr-1][nc] = 1;
                map[nr-2][nc] = 1;

                // 파랑
                nr = r;
                while (nc < SIZE && map[nr][nc] == 0 && map[nr+1][nc] == 0) {
                    nc++;
                }

                map[nr][nc-1] = 1;
                map[nr+1][nc-1] = 1;
                break;
        }
    }

    // 2. 초록 / 파랑 각각 진한 부분에 한줄 쌓였다면 삭제
    private static void boom() {
        // 초록: 6행 0열 ~ 9행 3열
        Stack<int[]> remain = new Stack<>();
        for (int i = 4; i < SIZE; i++) {
            int cnt = 0;
            int[] tmp = new int[5];
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) cnt++; // 블럭 개수 카운트
                tmp[j] = map[i][j]; // 임시배열에 담고
                map[i][j] = 0; // 비우기
            }

            if (cnt == 0) continue; // 블럭이 하나도 없으면 넘어간다

            tmp[4] = cnt; // 블럭 개수 판단
            remain.push(tmp);
        }

        int idx = 1;
        while (!remain.isEmpty()) {
            int[] tmp = remain.pop();
            if (tmp[4] == 4) { // 해당 행이 꽉 찼으면
                if (SIZE - idx > 5) { 
                    score++; // 점수++ (진한 색일때만)
                }
            } else { // 꽉 차지 않았다면(터지는 게 아니면)
                for (int i = 0; i < 4; i++) {
                    map[SIZE - idx][i] = tmp[i]; // 채워주기
                }
                idx++;
            }
        }

        // 파랑: 0행 6열 ~ 3행 9열 -> 열 별로 확인
        for (int i = 4; i < SIZE; i++) {
            int cnt = 0;
            int[] tmp = new int[5];
            for (int j = 0; j < 4; j++) {
                if (map[j][i] == 1) cnt++;
                tmp[j] = map[j][i];
                map[j][i] = 0; 
            }

            if (cnt == 0) continue;

            tmp[4] = cnt;
            remain.push(tmp);
        }

        idx = 1;
        while (!remain.isEmpty()) {
            int[] tmp = remain.pop();

            if (tmp[4] == 4) { 
                if (SIZE - idx > 5) {
                    score++; 
                }
            } else { 
                for (int i = 0; i < 4; i++) {
                    map[i][SIZE - idx] = tmp[i]; 
                }
                idx++;
            }
        }
    }

    private static void specialTile() {
        // 초록: 4~5행 0~3열, 파랑: 4~5열 0~3행
        int rowCnt = 0, colCnt = 0;
        for (int i = 4; i < 6; i++) {
            int curRowCnt = 0;
            int curColCnt = 0;
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) curRowCnt++;
                if (map[j][i] == 1) curColCnt++;
            }

            if (curRowCnt > 0) rowCnt++;
            if (curColCnt > 0) colCnt++;
        }

        if (rowCnt > 0 || colCnt > 0) {
            // rowCnt 만큼 내리기
            for (int i = SIZE - 1; i >= 4; i--) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = map[i - rowCnt][j];
                    map[j][i] = map[j][i - colCnt];
                }
            }
        }
    }
    
    // 타일 수 세기
    static int cntTile() {
        int tiles = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i >= 4 && j >= 4) continue;
                tiles += map[i][j];
            }
        }
        return tiles;
    }
}
