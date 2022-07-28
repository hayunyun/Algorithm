import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[5];
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] < min) min = nums[i];
        }

        while (true) {
            int cnt = 0;
            for (int num : nums) {
                if (min % num == 0) cnt++;
            }
            if (cnt >= 3) break;
            min++;
        }

        System.out.println(min);
    }
}