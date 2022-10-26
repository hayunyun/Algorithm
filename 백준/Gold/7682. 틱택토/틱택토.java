import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    코드 최적화 필요 (TEST 중)
     */
    static char[] map;
    static int[] xos;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            map = br.readLine().toCharArray();
            if (map.length == 3) break;

            xos = new int[2];
            int blanks = blankCnt();

            if (isValid(blanks)) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isValid(int blanks) {
        boolean[][] checkList = new boolean[2][4]; // 0: X, 1:O && 가로, 세로, 좌측대각, 우측대각
        for (int i = 0; i <= 2; i++) {
            // 가로
            if (map[i*3] != '.' && map[i*3] == map[i*3 + 1] && map[i*3 + 1] == map[i*3 + 2]) {
                int d = (map[i*3] == 'X') ? 0 : 1;
                checkList[d][0] = true;
            }
            // 세로
            if (map[i] != '.' && map[i] == map[i+3] && map[i+3] == map[i+6]) {
                int d = (map[i] == 'X') ? 0 : 1;
                checkList[d][1] = true;
            }
        }

        // 대각선
        if (map[0] != '.' && map[0] == map[4] && map[4] == map[8]) {
            int d = (map[0] == 'X') ? 0 : 1;
            checkList[d][2] = true;
        }
        if (map[2] != '.' && map[2] == map[4] && map[4] == map[6]) {
            int d = (map[2] == 'X') ? 0 : 1;
            checkList[d][3] = true;
        }

        int[] xoWin = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (checkList[i][j]) xoWin[i]++;
            }
        }

        // 양쪽 다 이긴 게 있으면 불가능
        if (xoWin[0] > 0 && xoWin[1] > 0) return false;

        if (xos[1] > xos[0] || xos[0] - xos[1] > 1) return false;

        boolean res;
        // 칸이 다 채워지지 않았을 경우, 무조건 하나가 체크되어야 함 (하나만)
        if (blanks > 0) {
            res = ((xoWin[0] == 1 && xos[0] - xos[1] == 1) || (xoWin[1] == 1 && (xos[0] - xos[1] == 0)));
        // 칸이 다 채워졌을 경우, 2~1개만 체크되거나, 아예 체크되지 않아야 함
        } else {
            // O가 이긴 경우
            if (xoWin[1] > 0) {
                res = (xos[0] - xos[1] == 0)  && (xoWin[1] == 1);
            // X가 이긴 경우
            } else {
                res = (xoWin[0] <= 2);
            }
        }

        return res;
    }

    static int blankCnt() {
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if (map[i] == '.') {
                cnt++;
            } else if (map[i] == 'X') {
                xos[0]++;
            } else {
                xos[1]++;
            }
        }

        return cnt;
    }
}
