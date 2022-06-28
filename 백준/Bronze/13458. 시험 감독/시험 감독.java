import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] -= a;
            sum++;
            if (nums[i] <= 0) continue;
            sum += nums[i] % b == 0 ? nums[i]/b : nums[i]/b + 1;
        }
        System.out.println(sum);
    }
}
