import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Fireball {
        int  m, s, d;

        public Fireball(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public String toString() {
            return "(" + m + ", " + s + ", " + d + ")";
        }
    }

    static int n, m, k;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fireball>[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 격자크기 n*n
        m = Integer.parseInt(st.nextToken()); // 발사하는 파이어볼 개수
        k = Integer.parseInt(st.nextToken()); // k번 이동

        map = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 행
            int c = Integer.parseInt(st.nextToken()) - 1; // 열
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 이동하는 칸 수 (속력)
            int d = Integer.parseInt(st.nextToken()); // 방향

            map[r][c].add(new Fireball(m, s, d));
        }

        for (int i = 1; i <= k; i++) {
            map = move();
            go();
        }

        System.out.println(sumTotal());

    }

    private static int sumTotal() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < map[i][j].size(); l++) {
                    sum += map[i][j].get(l).m;
                }
            }
        }
        return sum;
    }

    // 1. 파이어볼 이동
    static ArrayList<Fireball>[][] move() {
        ArrayList<Fireball>[][] newMap = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < map[i][j].size(); l++) {
                    Fireball fb = map[i][j].get(l);
                    int s = fb.s % n;
                    int nr = i + dr[fb.d] * s;
                    int nc = j + dc[fb.d] * s;

                    // 음수면 +n, n넘으면 -n
                    nr = nr < 0 ? nr + n : nr;
                    nr = nr >= n ? nr - n : nr;

                    nc = nc < 0 ? nc + n : nc;
                    nc = nc >= n ? nc - n : nc;

                    newMap[nr][nc].add(fb);
                }
            }
        }
        return newMap;
    }

    // 2. 합치고 나누기
    static void go() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 만약 두개 이상의 파이어볼이 있다면 파이어볼은 4개로 나누어진다.
                if (map[i][j].size() > 1) {
                    int sumM = 0, sumS = 0, sumD = 0, fbCnt = 0;
                    boolean[] isEven = new boolean[map[i][j].size()];
                    for (int l = 0; l < map[i][j].size(); l++) {
                        Fireball fb = map[i][j].get(l);
                        sumM += fb.m;
                        sumS += fb.s;
                        isEven[l] = (fb.d % 2 == 0); // 짝수면 T, 홀수면 F
                        fbCnt++;
                    }

                    int newM = sumM / 5; // 질량은 합쳐진 질량 합 / 5
                    int newS = sumS / fbCnt; // 속력은 합쳐진 속력 합 / 합쳐진 개수

                    // 맨앞 숫자의 홀/짝 기록해 놓고, 뒤의 것과 하나라도 다르면 반복문 빠져나옴
                    boolean prev = isEven[0];
                    boolean flag = true;
                    for (int l = 1; l < isEven.length; l++) {
                        if (prev != isEven[l]) {
                            flag = false;
                            break;
                        }
                    }

                    map[i][j].clear();
                    if (newM == 0) continue; // 질량이 0인 파이어볼은 없어진다.

                    // 방향이 모두 홀/짝이면 0, 2, 4, 6 && 아니면 1, 3, 5, 7
                    for (int l = 0; l < 8; l++) {
                        if (flag && l % 2 == 0) {
                            map[i][j].add(new Fireball(newM, newS, l));
                        }
                        else if (!flag && l % 2 != 0) {
                            map[i][j].add(new Fireball(newM, newS, l));
                        }
                    }
                }
            }
        }
    }
}