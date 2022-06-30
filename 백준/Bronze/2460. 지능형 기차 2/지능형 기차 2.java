import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[10];

        int max = -1;
        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            if (i != 0) nums[i] = nums[i-1];
            nums[i] = nums[i] - out + in;
            
            if (nums[i] > max) max = nums[i];
        }
        System.out.println(max);
    }
}
