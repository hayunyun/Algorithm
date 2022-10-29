import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 만족하는 수열 중 최댓값과 최솟값을 찾자
    static int n;
    static String min, max;
    static int[] nums;
    static char[] buho;
    static boolean[] digits;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        buho = new char[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            buho[i] = st.nextToken().charAt(0);
        }

        digits = new boolean[10]; // 0 ~ 9
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append("0");
        }
        max = sb.toString();

        sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append("9");
        }
        min = sb.toString();

        findWay(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void findWay(int cnt) {
        // 값 가능한지 체크하고 안되면 리턴
        if (cnt > 1 && cnt < n+2) {
            switch (buho[cnt-1]) {
                case '<':
                    if (nums[cnt-2] >= nums[cnt-1]) return;
                    break;
                case '>':
                    if (nums[cnt-2] <= nums[cnt-1]) return;
                    break;
            }
        }

        if (cnt == n+1) {
            // 최대 최소 비교하고 갱신
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
            }

            String value = sb.toString();
            if (Long.parseLong(min) > Long.parseLong(value)) {
                min = value;
            }

            if (Long.parseLong(max) < Long.parseLong(value)) {
                max = value;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!digits[i]) {
                digits[i] = true;
                nums[cnt] = i;
                findWay(cnt + 1);
                digits[i] = false;
            }
        }
    }
}
