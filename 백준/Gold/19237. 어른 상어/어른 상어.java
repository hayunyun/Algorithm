import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info {
        int r, c, num, d;

        // 상어: 상어 번호, 상어 방향
        // 냄새: 냄새나는 상어 번호, 잔여 시간
        public Info(int r, int c, int num, int d) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.d = d;
        }
    }
    static int n, m, k;
    static int[][] sharkMap;
    static Info[][] smellMap;
    static Queue<Info> sharkInfos; 
    static int[][][] sharkDir; // 상어 별 우선순위 저장
    // 상, 하, 좌, 우
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] sharks = new int [m+1][2];
        sharkMap = new int[n+1][n+1]; // 상어 정보 담음
        smellMap = new Info[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    sharkMap[i][j] = num;
                    sharks[num][0] = i;
                    sharks[num][1] = j;

                    // 냄새 뿌리기
                    smellMap[i][j] = new Info(i, j, num, k);
                } else {
                    smellMap[i][j] = new Info(i, j, 0, 0);
                }
            }
        }

        // 각 상어의 현재 방향까지 받아, 정보 기록
        sharkInfos = new LinkedList<>();
        Stack<Info> tmp = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            int[] sharkPos = sharks[i];
            int dir = Integer.parseInt(st.nextToken());
            sharkInfos.add(new Info(sharkPos[0], sharkPos[1], i, dir));
        }

        // 각 상어의 방향에 따른 우선순위 입력받기
        sharkDir = new int[m+1][5][5];
        for (int i = 1; i <= m; i++) { // 상어
            for (int j = 1; j <= 4; j++) { // 한 상어당 상하좌우 4번 입력
                st = new StringTokenizer(br.readLine());
                for (int l = 1; l <= 4; l++) {
                    sharkDir[i][j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int time = 0;
        while (time <= 1000) {
            sharkMove();
            time++;
            if (sharkInfos.size() == 1) break;
        }

        System.out.println(time > 1000 ? -1 : time);
    }

    static void sharkMove() {
        ArrayList<Info> tmp = new ArrayList<>();

        for (int i = sharkInfos.size(); i > 0; i--) {
            Info now = sharkInfos.poll();
            int num = now.num;
            int dir = now.d;
            boolean flag = false;
            for (int j = 1; j <= 2; j++) {
                for (int d = 1; d <= 4; d++) {
                    int nDir = sharkDir[num][dir][d];
                    int nr = now.r + dr[nDir];
                    int nc = now.c + dc[nDir];

                    if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) {
                        // 1. 인접한 칸 중 아무 냄새가 없는 칸
                        if (j == 1) {
                            if (smellMap[nr][nc].num == 0) {
                                // 이동 (임시배열에 담기 -> 한번에 처리
                                tmp.add(new Info(nr, nc, num, nDir));
                                sharkMap[now.r][now.c] = 0;
                                flag = true;
                                break;
                            }
                        } else {
                            // 2. 자신의 냄새가 있는 칸
                            if (smellMap[nr][nc].num == num) {
                                tmp.add(new Info(nr, nc, num, nDir));
                                sharkMap[now.r][now.c] = 0;
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if (flag) break;
            }
        }

        // 동시 이동
        for (Info info : tmp) {
            if (sharkMap[info.r][info.c] != 0) continue;
            sharkMap[info.r][info.c] = info.num;
            sharkInfos.add(info);
        }

        // 존재하는 냄새 1 빼주기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (smellMap[i][j].d - 1 > 0) {
                    smellMap[i][j].d--;
                } else {
                    smellMap[i][j].num = 0;
                    smellMap[i][j].d = 0;
                }
            }
        }

        // 새로 이동한 위치에 냄새 뿌리기
        for (Info info : tmp) {
            if (smellMap[info.r][info.c].num > 0 && smellMap[info.r][info.c].num < info.num) continue;
            smellMap[info.r][info.c] = new Info(info.r, info.c, info.num, k);
        }
    }
}
