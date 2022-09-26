import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        nums[1] = 1;

        int min = 0;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;

            // 제곱수를 최소로 하는 개수를 dp에 저장하는 방식 
            // i에서 i보다 작은 제곱수를 뺀 nums값 중 최소를 구한다.
            for (int j = 1; j * j <= i; j++) {
                int tmp = i - j*j;
                min = Math.min(min, nums[tmp]);
            }

            nums[i] = min + 1;
        }

        System.out.println(nums[n]);

    }
}