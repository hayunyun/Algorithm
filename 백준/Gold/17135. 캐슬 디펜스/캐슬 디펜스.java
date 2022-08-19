import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
     * 각 칸에 포함된 적의 수는 최대 하나
     * n + 1칸에는 성이 있다, 궁수 3명을 배치해야 한다.
     * 각 궁수는 턴마다 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다.
     * 궁수가 공격하는 적은 거리가 d 이하인 적 중에서 가장 가까운 적. 여럿일 경우에는 가장 왼쪽에 있는 적.
     * 같은 적이 여러 궁수에게 공격당할 수 있으며, 공격받으면 게임에서 제외된다.
     * 궁수의 공격이 끝나면 적이 이동한다. 아래로 한 칸 이동하며, 성이 있는 칸으로 이동하면 게임에서 제외
     * 모두 제외되면 게임 끝
     * 궁수의 공격으로 제거할 수 있는 적의 최대 수 계산
     * 거리 계산은 Math.abs(r1 - r2) + Math.abs(c1 - c2)
     */
    static int[] sel;
    static int n, m, d, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 궁수의 공격거리 제한
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sel = new int[3];
        combination(0, 0);
        System.out.println(ans);
//        game();
    }

    static void combination(int idx, int cnt) {
        if (cnt == sel.length) {
//			System.out.println(Arrays.toString(sel));
            // 게임 진행
            // 궁사의 행은 n, 열은 sel[i]

            int[][] archer = new int[3][2];
            for (int i = 0; i < 3; i++) {
                archer[i][0] = n;
                archer[i][1] = sel[i];
            }

            int[][] nowMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nowMap[i][j] = map[i][j];
                }
            }

//			System.out.println("------");
            game(archer, nowMap);
            return;
        }

        for (int i = idx; i < m; i++) {
            sel[cnt] = i;
            combination(i + 1, cnt + 1);
        }

    }

    static void game(int[][] ac, int[][] nowMap) {
        int enemyCnt = 0;

        while (true) {
            // 궁수의 배치는 -> m 중에 3개 조합 -> ac로 가져옴

            // 매 턴마다 궁수는 적 하나를 공격한다.
            // 아랫즐 왼쪽부터 보면서 값이 1일 경우 거리 비교 후 최솟값 기록 (같은거 x 더 작은거 o)
            // 본 줄에서 적이 있으면 윗줄 볼필요 x 적이 없으면 계속 진행 (~ 거리가 d 이하일때까지)
            Queue<int[]> enemy = new LinkedList<>();

            for (int k = 0; k < 3; k++) {
                int[] nowAc = ac[k];
                int min = Integer.MAX_VALUE;
                int minR = -1, minC = Integer.MIN_VALUE;
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        if (nowMap[i][j] == 1) {
                            int dist = Math.abs(nowAc[0] - i) + Math.abs(nowAc[1] - j);
                            // TODO 같은거리면 왼쪽 처리
                            if (dist <= d) {
                                if (dist < min) {
                                    min = dist;
                                    minR = i; minC = j;
                                } else if (dist == min) {
                                    if (minC > j) {
                                        minR = i; minC = j;
                                    }
                                    // 현재 열이 minLeft보다 크면 갱신하지 않는다
                                }
                            }
                        }
                    }
                }

                if (minR != -1 && minC != -1) {
                    enemy.add(new int[] {minR, minC});
                }
            }


            // 가장 가까운 적의 위치를 기록하고, 동시에 공격 -> 큐에 담음
//			Queue<int[]> enemy = new LinkedList<>();

            // 공격받은 적은 제외됨 -> 해당 위치를 0으로 만듦, enemyCnt++;
//			if (enemy.isEmpty()) break;
            while (!enemy.isEmpty()) {
                int[] nowEn = enemy.poll();

                int r = nowEn[0];
                int c = nowEn[1];

                if (nowMap[r][c] == 1) {
                    nowMap[r][c] = 0;
                    enemyCnt++;
                }
            }


            // 한 분기가 지날 때마다 적은 아래로 한 칸 이동
            int sum = 0;
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 0; j < m; j++) {
                    nowMap[i][j] = nowMap[i - 1][j];
                    sum += nowMap[i][j];
                }
            }

            // n+1로 이동할 경우 게임에서 제외
            for (int j = 0; j < m; j++) {
                nowMap[0][j] = 0;
            }

            // 모든 적이 제외되면 게임 끝
            if (sum <= 0) break;
        }

        ans = Math.max(ans, enemyCnt);
    }

}