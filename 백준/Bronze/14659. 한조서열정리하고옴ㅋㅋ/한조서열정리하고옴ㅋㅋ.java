import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    total++;
                }
                else break;
            }
            ans = Integer.max(ans, total);
        }

        System.out.println(ans);
    }
}