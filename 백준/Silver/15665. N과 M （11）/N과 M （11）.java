import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nums, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        ans = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 오름차순 정렬

        backTrack(0);
        System.out.println(sb);
    }

    static void backTrack(int depth) {
        if (depth == m) {
            for (int num : ans) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                ans[depth] = nums[i];
                backTrack(depth + 1);
            }
        }

    }
}
