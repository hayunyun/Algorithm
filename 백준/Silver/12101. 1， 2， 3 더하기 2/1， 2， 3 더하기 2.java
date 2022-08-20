import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, totalCnt;
    static int[] nums = {1, 2, 3};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        recursive(new int[12], 0, 0);
        if (totalCnt < k) {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static void recursive(int[] sel, int sum, int cnt) {
        if (sum > n) return;

        if (sum == n) {
            if (totalCnt == k - 1) {
                for (int i = 0; i < cnt; i++) {
                    sb.append(sel[i]);
                    if (i != cnt - 1) sb.append("+");
                }
            }
            totalCnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            sel[cnt] = nums[i];
            recursive( sel, sum + nums[i], cnt + 1);
        }
    }
}
