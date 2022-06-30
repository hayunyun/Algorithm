import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nums = new String[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.next();
        }

        long sum = Long.parseLong(nums[0]+nums[1]) + Long.parseLong(nums[2]+nums[3]);
        System.out.println(sum);
    }
}
