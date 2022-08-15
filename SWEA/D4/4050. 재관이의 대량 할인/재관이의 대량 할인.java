import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);
            int sum = 0;
            int idx = n - 1;
            int cnt = 1;

            while (idx >= 0) {
                if (cnt == 3) {
                    cnt = 1;
                    idx--;
                    continue;
                }
                sum += nums[idx--];
                cnt++;
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
