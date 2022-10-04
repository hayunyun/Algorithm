import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo(n);
        System.out.println(nums[n] + " " + cnt);
    }

    static void fibo(int n) {
        nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
            cnt++;
        }
    }
}
