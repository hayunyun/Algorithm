import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static HashSet<Integer>[] info;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        info = new HashSet[n*n + 1];
        for (int i = 1; i <= n*n; i++) {
            info[i] = new HashSet<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            info[student].add(Integer.parseInt(st.nextToken()));
            info[student].add(Integer.parseInt(st.nextToken()));
            info[student].add(Integer.parseInt(st.nextToken()));
            info[student].add(Integer.parseInt(st.nextToken()));
            setPos(student, info[student]);
        }

        // 만족도 구하기
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += getScore(i, j, map[i][j]);
            }
        }

        System.out.println(total);
    }

    static int getScore(int r, int c, int student) {
        int cur = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isPossible(nr, nc) && info[student].contains(map[nr][nc])) {
                cur++;
            }
        }

        int score;
        if (cur == 0) {
            score = 0;
        }
        else {
            score = (int)Math.pow(10, cur-1);
        }
        return score;
    }

    static void setPos(int student, HashSet<Integer> friends) {
        // 1. 비어있는 칸 중에서 '좋아하는 학생이 인접한 칸에 가장 많은 칸'으로 자리를 정한다.
        int maxVal = Integer.MIN_VALUE;
        int[] maxIdx = {-1, -1};
        Queue<int[]> idxs = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = 0;
                if (map[i][j] == 0) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (isPossible(nr, nc) && friends.contains(map[nr][nc])) {
                            cur++;
                        }
                    }
                    if (cur > maxVal) {
                        maxVal = cur;
                        idxs.clear();
                        idxs.add(new int[] {i, j});
                    } else if (cur == maxVal) {
                        idxs.add(new int[] {i, j});
                    }
                }
            }
        }

        // 칸이 비어있다면, '좋아하는 학생이 인접한 칸에 가장 많은 칸'을 갱신한다.
        // 다 탐색 후 가장 많은 칸이 여러개라면 2로 넘어간다.
        if (idxs.size() == 1) {
            int[] max = idxs.poll();
            map[max[0]][max[1]] = student;
            return;
        }

        // 2. 1을 만족하는 칸이 여러 개이면, '인접한 칸 중에서 비어있는 칸이 가장 많은 칸'
        // 탐색하며 '인접한 칸 중에서 비어있는 칸이 가장 많은 칸'을 갱신한다.
        // 다 탐색 후 가장 많은 칸이 여러개라면 2로 넘어간다.
        maxVal = Integer.MIN_VALUE;

        while (!idxs.isEmpty()) {
            int[] now = idxs.poll();
            int cur = 0;

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (isPossible(nr, nc) && map[nr][nc] == 0) {
                    cur++;
                }
            }

            if (cur > maxVal) {
                maxVal = cur;
                maxIdx[0] = now[0];
                maxIdx[1] = now[1];
            }
        }

        // 3. 2를 만족하는 칸도 여러 개인 경우에는 '행의 번호가 가장 작은 칸'으로, 그러한 칸도 여러 개이면 '열의 번호가 가장 작은 칸'
        // 2를 만족하는 칸 중 행 작은 칸 확인 -> 여러개면 열 작은 칸 확인
        map[maxIdx[0]][maxIdx[1]] = student;
    }

    static boolean isPossible(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}