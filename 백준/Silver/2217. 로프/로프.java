import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int[] total = new int[n];
        total[0] = nums[0] * n;
        for (int i = 1; i < n; i++) {
            total[i] = nums[i] * (n - i);
        }

        Arrays.sort(total);
        System.out.println(total[total.length - 1]);
    }
}