import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Charger {
        int row, col, c, p; // 충전 범위, 성능

        public Charger(int row, int col, int c, int p) {
            this.row = row;
            this.col = col;
            this.c = c;
            this.p = p;
        }
    }
    static class Person {
        int r, c;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int m, a;
    static ArrayList<Charger> chargers;
    static int[][] times;
    static int[] dr = {0, -1, 0, 1, 0}; // 이동없음, 상, 우, 하, 좌
    static int[] dc = {0, 0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken()); // 충전소 개수

            times = new int[2][m+1]; // 사람A,B의 시간 별 이동궤적 기록
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    times[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            chargers = new ArrayList<>(); // 충전소 기록
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                chargers.add(new Charger(col, row, c, p));
            }

            Person[] people = new Person[2];
            people[0] = new Person(1, 1);
            people[1] = new Person(10, 10);
            int total = 0;
            for (int i = 0; i <= m; i++) { // m초 동안 진행
                int[][] nowP = new int[2][a]; // 현재 위치에서 가능한 충전량 기록하는 배열
                int dir;
                for (int per = 0; per < 2; per++) {
                    Person now = people[per];
                    dir = times[per][i];
                    now.r += dr[dir];
                    now.c += dc[dir];
                    for (int k = 0; k < a; k++) {
                        Charger charger = chargers.get(k);
                        if (Math.abs(now.c - charger.row) + Math.abs(now.r - charger.col) <= charger.c) {
                            nowP[per][k] = charger.p;
                        }
                    }
                }

                int max = 0;
                for (int j = 0; j < a; j++) { // 사람 a가 선택한 충전기
                    for (int k = 0; k < a; k++) { // 사람 b가 선택한 충전기
                        int sum;
                        if (j != k) { // 서로 선택한 충전기가 다르다면 바로 더하면 됨
                            sum = nowP[0][j] + nowP[1][k];
                        } else { // 충전기가 같다면, 둘 중 더 큰 값 가져오기
                            sum = Math.max(nowP[0][j], nowP[1][k]);
                        }

                        if (max < sum) { // 충전기 선택 중 가장 큰 값 기록
                            max = sum;
                        }
                    }
                }
                total += max;

            }

            sb.append("#" + tc + " " + total + "\n");
        }
        System.out.println(sb);
    }

}
