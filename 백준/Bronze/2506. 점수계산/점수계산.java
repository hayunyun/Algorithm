import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int score = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (i != 0 && nums[i] == 1 && nums[i-1] != 0) {
                nums[i] = nums[i-1] + 1;
            }
            score += nums[i];
        }
        System.out.println(score);
    }
}
