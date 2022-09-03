import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int n;
    static int[] nums, buhos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        buhos = new int[4]; // +, -, *, /
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            buhos[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, n - 1, nums[0]); // 피연산자, 사용 가능한 연산자 개수, 누적 결과
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int idx, int cnt, int res) {
        if (cnt == 0) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (buhos[i] > 0) { // 사용 가능한 연산자가 있다면 연산 수행
                buhos[i]--; // 연산자 사용

                int cur = 0;
                switch (i) {
                    case 0: cur = res + nums[idx]; break;
                    case 1: cur = res - nums[idx]; break;
                    case 2: cur = res * nums[idx]; break;
                    case 3: cur = res / nums[idx]; break;
                }

                solve(idx + 1, cnt - 1, cur);
                buhos[i]++; // 사용했던 것 다시 복구
            }
        }

    }
}
