import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[5];
        int avg = 0;
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
            avg += nums[i];
        }
        Arrays.sort(nums);
        System.out.println(avg/5);
        System.out.println(nums[2]);
    }
}
