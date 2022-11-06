import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /*
    빨간색 보드에 놓으면,
    - 초록색으로 이동 (경계에 닿을 때까지)
    - 파란색으로 이동 (경계에 닿을 때까지)

    한 행/열이 타일로 가득 차면, 그 행/열 타일은 모두 사라진다. (초록: 행, 파랑: 열)
    위에 쌓여 있던 것들도 없어진 타일 수 만큼 아래로 내려온다.
    사라지면 사라진 행/열 만큼 점수++
    특별한 행/열 (0, 1)에 블럭이 쌓이면, 블럭이 있는 행/열의 수 만큼 맨 아래/오른쪽 행/열이 모두 사라지고, 사라진 행/열 (1~2)만큼 칸 이동

    행/열 가득차거나 연한칸에 차는게 동시발생한다면, 행/열을 먼저 비워서 점수를 획득한 후, 연한칸 블록 처리

    총 점수, 초록색 보드에 타일이 있는 칸의 개수, 파란색 보드에 타일이 있는 칸의 개수 구해보자
     */
    static final int SIZE = 10;
    static int score = 0;
    static int[][] map = new int[SIZE][SIZE];
    static int[] dr = {1, 0}; // 상 우
    static int[] dc = {0, 1};
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
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

//        print();
        System.out.println(score);
        System.out.println(cntTile());
    }

    private static void game(int t, int r, int c) {
        // 1. 블럭 쌓기
        // 0이 아닐 떄 까지 계속 하강 (초록, 파랑)
        stacked(t, r, c);

        // 2. 4개 모인 곳 모두 터지고, 쌓이기
        boom();

        // 3. 연한 칸에 블록이 있는지 색깔별 판단
        specialTile();
//        print();

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
//            System.out.println("연한 칸에 있는 건 " + rowCnt + ", " + colCnt);
            // rowCnt 만큼 내리기
            for (int i = SIZE - 1; i >= 4; i--) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = map[i - rowCnt][j];
                    map[j][i] = map[j][i - colCnt];
//                System.out.println(j + "행 " + i + "열 <- " + j + "행 " + (i - colCnt) + "열");
                }
            }
        }
    }

    private static void boom() {
        // 2. 초록 / 파랑 각각 진한 부분에 한줄 쌓였다면 삭제
        // 초록: 6행 0열 ~ 9행 3열
//        boolean[] row = new boolean[SIZE];
        Stack<int[]> remain = new Stack<>();
        for (int i = 4; i < SIZE; i++) {
            int cnt = 0;
            int[] tmp = new int[5];
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) cnt++;
                tmp[j] = map[i][j];
                map[i][j] = 0; // 일단 비우기 TODO
            }

            if (cnt == 0) continue;

//            if (cnt == 4) {
//                row[i] = true;
//                System.out.println(i + "행은 다 찼습니다");
//            }
            tmp[4] = cnt;

//            System.out.println(Arrays.toString(tmp) + " 넣는다");
            remain.push(tmp);
        }

//        System.out.println("초록----");
        int idx = 1;
        while (!remain.isEmpty()) {
            int[] tmp = remain.pop();
//            if (row[SIZE - idx]) { // 해당 행이 꽉 찼으면
            if (tmp[4] == 4) { // 해당 행이 꽉 찼으면
//                Arrays.fill(map[SIZE - idx], 0); // 터트리고 TODO
                if (SIZE - idx > 5) {
//                    System.out.println((SIZE - idx) + "행 터짐");
                    score++; // 점수 추가 (진한 색일때만)
//                    row[SIZE - idx] = false;
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    map[SIZE - idx][i] = tmp[i]; // 채워주기
                }
                idx++;
            }
        }

        // 파랑: 0행 6열 ~ 3행 9열 -> 열 별로 확인
//        System.out.println("파랑----");
//        boolean[] col = new boolean[SIZE];
        for (int i = 4; i < SIZE; i++) {
            int cnt = 0;
            int[] tmp = new int[5];
            for (int j = 0; j < 4; j++) {
                if (map[j][i] == 1) cnt++;
                tmp[j] = map[j][i];
                map[j][i] = 0; // 일단 비우기 TODO
            }

            if (cnt == 0) continue;

//            if (cnt == 4) {
//                col[i] = true;
//            }
            tmp[4] = cnt;

            remain.push(tmp);
        }

        idx = 1;
        while (!remain.isEmpty()) {
            int[] tmp = remain.pop();

            if (tmp[4] == 4) { // 해당 열이 꽉 찼으면
//                for (int i = 0; i < 4; i++) { // 터트리고
//                    map[i][SIZE - idx] = 0;
//                }
                if (SIZE - idx > 5) {
//                    System.out.println((SIZE - idx) + "열 터짐");
                    score++; // 점수 추가 (진한 색일때만)
//                    col[SIZE - idx] = false;
                }
            } else { // 터지는 게 아니면
                for (int i = 0; i < 4; i++) {
                    map[i][SIZE - idx] = tmp[i]; // 채워주기
                }
                idx++;
            }
        }
    }

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

    static int cntTile() {
        int tiles = 0;
        // 초록
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i >= 4 && j >= 4) continue;
                tiles += map[i][j];
            }
        }
        return tiles;
    }

    static void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i >= 4 && j >= 4) continue;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}
