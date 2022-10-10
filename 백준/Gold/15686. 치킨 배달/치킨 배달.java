import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] map;
    static Info [] sel;
    static ArrayList<Info> chickens = new ArrayList<>();
    static ArrayList<Info> houses = new ArrayList<>();
    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // m개의 치킨집 선택

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new Info(i, j));
                } else if (map[i][j] == 1) {
                    houses.add(new Info(i, j));
                }
            }
        }

        sel = new Info[m]; // 선택된 m개의 치킨집
        ans = Integer.MAX_VALUE;
        getChicken(0, 0);
        System.out.println(ans);
    }

    /*
    1. m개까지 치킨집 설치 -> 조합
    2. 치킨거리 구하고, 최소 치킨거리 갱신
     */
    static void getChicken(int idx, int cnt) {
        if (cnt == m) {
            ans = Math.min(ans, getDist());
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            Info c = chickens.get(i);
            sel[cnt] = c;
            getChicken(i + 1, cnt + 1);
        }
    }

    static int getDist() {
        // 집이랑 sel에 담긴거 하나하나 보며 최소거리 합 구하고 갱신
        int total = 0;
        for (int i = 0; i < houses.size(); i++) {
            Info house = houses.get(i);
            int dist = Integer.MAX_VALUE;

            for (int j = 0; j < sel.length; j++) {
                Info chic = sel[j];

                int cur = Math.abs(house.r - chic.r) + Math.abs(house.c - chic.c);
                if (cur < dist) dist = cur;
            }
            total += dist;
        }

        return total;
    }
}
