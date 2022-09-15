import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] info;
    static int[] order = new int[9];
    static boolean[] vis = new boolean[9];
    static int n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        info = new int[n][9];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MIN_VALUE;
        permutation(0);

        System.out.println(ans);
    }

    static void permutation(int cnt) {
        if (cnt > 3 && order[3] != 0) {
            return;
        }

        if (cnt == 9) {
            game();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!vis[i]) {
                vis[i] = true;
                order[cnt] = i;
                permutation(cnt + 1);
                vis[i] = false;
            }
        }
    }

    /*
    1. 순열로 선수 순서 정함 (단, 4번째는 0번)
    2. 이닝 수만큼 게임 진행
    2-1. 첫번째 순서의 선수부터 돌면서 게임 진행
    2-2. 1,2,3,4 에 따라 다르게 점수 산출, 도루 표시
    2-3. 아웃 3번 나올때까지 진행, 3번 나오면 이닝 종료
     */
    static void game() {
        int score = 0, now = 0;
        int out;
        boolean[] doru; // 0: 도루, 1: 1루, 2: 2루, 3: 3루

        for (int i = 0; i < n; i++) {
            doru = new boolean[4];
            out = 0;
            while (true) {
                int ball = info[i][order[now]];
                switch (ball) {
                    case 1:
                        for (int j = 3; j >= 1; j--) {
                            if (doru[j]) {
                                if (j == 3) {
                                    doru[3] = false;
                                    score++;
                                } else {
                                    doru[j] = false;
                                    doru[j+1] = true;
                                }
                            }
                        }
                        doru[1] = true;
                        break;
                    case 2:
                        for (int j = 3; j >= 2; j--) {
                            if (doru[j]) {
                                score++;
                                doru[j] = false;
                            }
                        }
                        if (doru[1]) {
                            doru[1] = false;
                            doru[3] = true;
                        }
                        doru[2] = true;
                        break;
                    case 3:
                        for (int j = 3; j >= 1; j--) {
                            if (doru[j]) {
                                score++;
                                doru[j] = false;
                            }
                        }
                        doru[3] = true;
                        break;
                    case 4:
                        for (int j = 3; j >= 1; j--) {
                            if (doru[j]) {
                                score++;
                                doru[j] = false;
                            }
                        }
                        score++;
                        break;
                    case 0:
                        out++;
                        break;
                }
                now = (now + 1) % 9;
                if (out == 3) break;
            }
        }
        ans = Math.max(ans, score);
    }
}
