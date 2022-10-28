import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        // 낮은 레벨의 경험치가 높은 레벨의 경험치보다 크다면, 높은 레벨의 경험치보다 1 작게 만드는게 최소 연산
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i+1]) {
                int diff = (nums[i] - nums[i+1]) + 1;
                sum += diff;
                nums[i] -= diff; // 연산해주기
            }
        }

        System.out.println(sum);
    }
}
