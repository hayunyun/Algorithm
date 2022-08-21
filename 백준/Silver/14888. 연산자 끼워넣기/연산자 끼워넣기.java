import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int n;
    static int[] nums, buhos;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        buhos = new int[4]; // +, -, *, /
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            buhos[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, n - 1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int idx, int cnt, int res) {
        if (idx > n) return;

        if (cnt == 0) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        if (buhos[0] > 0) {
            buhos[0]--;
            solve(idx + 1, cnt - 1, res + nums[idx]);
            buhos[0]++;
        }

        if (buhos[1] > 0) {
            buhos[1]--;
            solve(idx + 1, cnt - 1, res - nums[idx]);
            buhos[1]++;
        }

        if (buhos[2] > 0) {
            buhos[2]--;
            solve(idx + 1, cnt - 1, res * nums[idx]);
            buhos[2]++;
        }

        if (buhos[3] > 0) {
            buhos[3]--;
            solve(idx + 1, cnt - 1, res / nums[idx]);
            buhos[3]++;
        }
    }
}
