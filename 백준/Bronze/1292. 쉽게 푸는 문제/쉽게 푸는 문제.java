import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] nums = new int[b+1];
        int cnt = 1;
        int n = 1;

        for (int i = 1; i <= b; i++) {
            nums[i] += nums[i-1] + n;
            if (n == cnt) {
                n++;
                cnt = 1;
            }
            else cnt++;
        }

        System.out.println(nums[b] - nums[a-1]);
    }
}
