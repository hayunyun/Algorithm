import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nums, sel;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        vis = new boolean[n];
        sel = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        select(0);
        System.out.println(sb);
    }

    static void select(int cnt) {
        if (cnt == m) {
            for (int x : sel) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        int last = 0; // 이전에 뽑았던 값 저장
        for (int i = 0; i < n; i++) {
            if (!vis[i] && last != nums[i]) { // 뽑았던 값이 아니면
                vis[i] = true;
                sel[cnt] = nums[i];
                last = nums[i];
                select(cnt + 1);
                vis[i] = false;
            }
        }
    }
}
