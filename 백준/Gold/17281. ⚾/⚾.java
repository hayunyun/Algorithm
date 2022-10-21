import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     * 큐 말고 리스트로 구현해보기
     */
    static int n, maxScore;
    static int[] order;
    static int[][] scores;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][9];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis = new boolean[9];
        order = new int[9];
        order[3] = 0;
        vis[0] = true;
        maxScore = Integer.MIN_VALUE;
        permutation(0);
        System.out.println(maxScore);
    }

    static void permutation(int cnt) {
        if (cnt == 3) {
            cnt++;
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

    private static void game() {
        // 1루, 2루, 3루 표시
        boolean[] pos;
        int score = 0;
		int now = 0;
        int out;
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < 9; i++) {
//            q.add(order[i]);
//        }

        // n회 이닝 진행
        for (int i = 0; i < n; i++) {
            // 3아웃일때까지 한 라운드가 계속된다
            pos = new boolean[4];
            out = 0;
            while (out < 3) {
				int ball = scores[i][order[now]];
//                int now = q.poll();

				switch(ball) {
                    case 1: // 안타 - 한 루씩 진루
                        if (pos[3]) {
                            score++;
                            pos[3] = false;
                        }

                        if (pos[2]) {
                            pos[2] = false;
                            pos[3] = true;
                        }

                        if (pos[1]) {
                            pos[1] = false;
                            pos[2] = true;
                        }

                        pos[1] = true;
                        break;
                    case 2: // 2루타 - 3,2루 점수얻고 1루는 3루로, 타자는 2루로
                        if (pos[3]) {
                            score++;
                            pos[3] = false;
                        }

                        if (pos[2]) {
                            score++;
                            pos[2] = false;
                        }

                        if (pos[1]) {
                            pos[1] = false;
                            pos[3] = true;
                        }

                        pos[2] = true;
                        break;
                    case 3: // 3루타 - 3, 2, 1루 점수얻고, 타자는 3루로
                        if (pos[3]) {
                            pos[3] = false;
                            score++;
                        }

                        if (pos[2]) {
                            pos[2] = false;
                            score++;
                        }

                        if (pos[1]) {
                            pos[1] = false;
                            score++;
                        }

                        pos[3] = true;
                        break;
                    case 4: // 홈런
                        if (pos[3]) {
                            pos[3] = false;
                            score++;
                        }

                        if (pos[2]) {
                            pos[2] = false;
                            score++;
                        }

                        if (pos[1]) {
                            pos[1] = false;
                            score++;
                        }

                        score++;
                        break;
                    case 0: // 아웃
                        out++;
                        break;
                }
                now = (now + 1) % 9;
//                q.add(now);
            }
        }

        maxScore = Math.max(maxScore, score);
    }
}
