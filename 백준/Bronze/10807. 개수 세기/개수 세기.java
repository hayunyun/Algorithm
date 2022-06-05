import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int[] nums = new int[a];

        for (int i = 0; i < a; i++) {
            nums[i] = sc.nextInt();
        }
            int v = sc.nextInt();
            int cnt = 0;

        for (int i = 0; i < a; i++) {
            if (v == nums[i]) cnt++;
        }
            System.out.println(cnt);
        }
}
