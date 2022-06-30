import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a==b && b==c) {
                nums[i] = 10000 + a * 1000;
            }
            else if (a!=b && a!=c && b!=c) {
                nums[i] = Math.max(a, Math.max(b,c)) * 100;
            }
            else {
                if (a==b || a==c) {
                    nums[i] = 1000 + a * 100;
                }
                else {
                    nums[i] = 1000 + b * 100;
                }
            }
            if (nums[i] > max) max = nums[i];
        }
        System.out.println(max);
    }
}
