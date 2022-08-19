import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] nums = new long[101];

        for (int i = 1; i <= 3; i++) {
            nums[i] = 1;
        }

        for (int i = 4; i <= 100; i++) {
            nums[i] = nums[i - 2] + nums [i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(nums[n]).append("\n");
        }
        System.out.println(sb);

    }
}