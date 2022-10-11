import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    /*
    1. 현재 길이를 4등분해서 16진수->10진수로 바꾸고 숫자 목록에 넣기
    2. 시계방향 1칸 회전 후 반복 -> 원래자리로 돌아올 때 까지 (n번이 될때까지 반복)
    */
    static int n, k;
    static char[][] nums;
    static TreeSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            nums = new char[4][n/4];

            String str = br.readLine();
            for (int i = 0; i < 4; i++) {
                for (int j = n/4 * i; j < n/4 * i + n/4; j++) {
                    nums[i][j - n/4 * i] = str.charAt(j);
                }
            }

            set = new TreeSet<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                check();
                turn();
            }

            // k번째로 큰 수 꺼내기
            List<Integer> list = new ArrayList<>(set);
            sb.append("#" + tc + " " + list.get(k-1) + "\n");
        }
        System.out.println(sb);
    }

    static void turn() {
        char tmp = nums[3][n/4 - 1];
        for (int i = 3; i >= 0; i--) {
            for (int j = n/4 - 1; j > 0; j--) {
                nums[i][j] = nums[i][j-1];
            }
            if (i != 0) {
                nums[i][0] = nums[i-1][n/4 - 1];
            }
        }
        nums[0][0] = tmp;
    }

    static void check() {
        for (int i = 0; i < 4; i++) {
            String s = new String(nums[i]);
//            System.out.println(Integer.parseInt(s, 16));
            set.add(Integer.parseInt(s, 16));
        }
    }
}
