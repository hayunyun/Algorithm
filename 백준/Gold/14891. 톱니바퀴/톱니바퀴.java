import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] wheel;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheel = new char[4][8]; // 톱니바퀴 정보 담는 배열
        check = new boolean[4]; // 맞닿은 톱니바퀴의 극이 같은지 체크하는 배열

        // input
        for (int i = 0; i < 4; i++) {
            wheel[i] = br.readLine().toCharArray();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken()) - 1; // 0번부터 시작이므로 -1해주기
            int dir = Integer.parseInt(st.nextToken()); // 방향

            isSame(idx); // 맞닿은 톱니바퀴들의 극이 같은지 체크
            turn(idx, dir); // 현재 idx 먼저 회전

            // check[j] == false면 반대 방향으로 회전 (맞닿지 않을 경우 회전이므로)
            int tmpLeft = idx, tmpRight = idx;
            int left = idx - 1, right = idx + 1;
            while(left >= 0 || right < 4) {
                dir = dir * (-1);

                if (left >= 0 && !check[tmpLeft] && !check[left]) turn(left, dir);
                if (right < 4 && !check[tmpRight] && !check[right]) turn(right, dir);

                left--; tmpLeft--; right++; tmpRight++;
            }

            // 다음 연산을 위해 check 배열 초기화
            for (int j = 0; j < 4; j++) {
                check[j] = false;
            }
        }

        // 점수 산출
        System.out.println(getScore());

    }

    static void isSame(int idx) {
        int tmpLeft = idx, tmpRight = idx;
        int left = idx - 1;
        int right = idx + 1;

        // 맞닿은 부분의 극이 같다면, true, 아니라면 false

        while (left >= 0) {
            if (check[tmpLeft]) {
                check[left] = true;
            }
            else {
                check[left] = (wheel[left][2] == wheel[tmpLeft][6]);
            }
            left--; tmpLeft--;
        }

        while (right < 4) {
            if (check[tmpRight]) {
                check[right] = true;
            }
            else {
                check[right] = (wheel[tmpRight][2] == wheel[right][6]);
            }
            right++; tmpRight++;
        }
    }

    static void turn(int idx, int dir) {
        char tmp;
        switch (dir) {
            // 시계
            case 1:
                tmp = wheel[idx][7];
                for (int i = 6; i >= 0; i--) {
                    wheel[idx][i + 1] = wheel[idx][i];
                }
                wheel[idx][0] = tmp;
                break;
            // 반시계
            case -1:
                tmp = wheel[idx][0];
                for (int i = 0; i < 7; i++) {
                    wheel[idx][i] = wheel[idx][i + 1];
                }
                wheel[idx][7] = tmp;
                break;
        }
    }

    static int getScore() {
        // 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        // 2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        // 3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        // 4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += wheel[i][0] == '0' ? 0 : (int)Math.pow(2, i);
        }
        return score;
    }
}