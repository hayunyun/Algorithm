import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    /*
    1. A[r][c]의 값이 k인지 확인
    2. k가 아닐 경우 연산 진행
    - 행 >= 열인 경우 행연산
    - 행 < 열인 경우 열연산
    3. 100초를 넘어가면 연산 중단, -1 출력
     */
    static class Info implements Comparable<Info> {
        int num, cnt;

        public Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            }
            return this.cnt - o.cnt;
        }
    }
    static int r, c, k, time;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row, col;
        while (!isIn() && time <= 100) {
            row = map.length;
            col = map[0].length;

            if (row >= col) { // 행연산
                rowCal(row, col);
            } else { // 열연산
                colCal(row, col);
            }

            time++;
        }

        System.out.println(time > 100 ? -1 : time);

    }

    static void rowCal(int row, int col) {
        int[] nums = new int[101]; // 1~100
        ArrayList<Info>[] rows = new ArrayList[row];

        for (int i = 0; i < row; i++) {
            Arrays.fill(nums, 0);
            ArrayList<Info> tmp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                int now = map[i][j];
                nums[now]++;
            }

            for (int j = 1; j <= 100; j++) {
                if (nums[j] > 0) {
                    tmp.add(new Info(j, nums[j]));
                }
            }

            // 수의 등장횟수 오름차순 -> 같은게 있으면 숫자 오름차순
            Collections.sort(tmp);
            rows[i] = tmp;
        }

        int maxSize = -1;
        for (ArrayList<Info> r : rows) {
            if (maxSize < r.size() * 2) {
                maxSize = r.size() * 2;
            }
        }
        
        if (maxSize > 100) maxSize = 100;

        // 새로운 맵에 값 할당    
        if (maxSize > 100) maxSize = 100;
        map = new int[row][maxSize];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < maxSize; j += 2) {
                if (j/2 < rows[i].size()) {
                    map[i][j] = rows[i].get(j/2).num;
                    map[i][j+1] = rows[i].get(j/2).cnt;
                } else {
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    static void colCal(int row, int col) {
        int[] nums = new int[101]; // 1~100
        ArrayList<Info>[] cols = new ArrayList[col];

        for (int i = 0; i < col; i++) {
            Arrays.fill(nums, 0);
            ArrayList<Info> tmp = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                int now = map[j][i];
                nums[now]++;
            }

            for (int j = 1; j <= 100; j++) {
                if (nums[j] > 0) {
                    tmp.add(new Info(j, nums[j]));
                }
            }

            // 수의 등장횟수 오름차순 -> 같은게 있으면 숫자 오름차순
            Collections.sort(tmp);
            cols[i] = tmp;
        }

        int maxSize = -1;
        for (ArrayList<Info> c : cols) {
            if (maxSize < c.size() * 2) {
                maxSize = c.size() * 2;
            }
        }
        
        if (maxSize > 100) maxSize = 100;

        // 새로운 맵에 값 할당    
        map = new int[maxSize][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < maxSize; j += 2) {
                if (j/2 < cols[i].size()) {
                    map[j][i] = cols[i].get(j/2).num;
                    map[j+1][i] = cols[i].get(j/2).cnt;
                } else {
                    map[j][i] = 0;
                    map[j+1][i] = 0;
                }
            }
        }
    }

    static boolean isIn() {
        return r < map.length && c < map[0].length && map[r][c] == k;
    }
}
