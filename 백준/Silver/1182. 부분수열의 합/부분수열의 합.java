import java.io.*;
import java.util.*;

public class Main {
    static int a, b, cnt;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        nums = new int[a];
        visited = new boolean[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backTrack(0, 0);
        if (b == 0) cnt -= 1;
        System.out.println(cnt);
    }

    static void backTrack(int idx, int sum) {
        if (idx == a) {
            if (sum == b) cnt++;
            return;
        }

        backTrack(idx + 1, sum); // 본인 미포함
        backTrack(idx + 1, sum + nums[idx]); // 본인 포함
    }
}