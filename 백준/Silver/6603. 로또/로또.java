import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] nums, sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            nums = new int[k];
            sel = new int[6];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            lotto(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void lotto(int idx, int cnt) {
        if (cnt == 6) {
            for (int n : sel) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            sel[cnt] = nums[i];
            lotto(i + 1, cnt + 1);
        }
    }
}
