import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] nums = new int [9];
    static boolean[] check = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        findDwarf(0, 0, 0);
    }

    static void findDwarf(int idx, int cnt, int sum) {
        if (idx == nums.length) {
            if (cnt == 7 && sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (check[i])
                        System.out.println(nums[i]);
                }
            }
            return;
        }

        // 넣음
        check[idx] = true;
        findDwarf(idx + 1, cnt + 1, sum + nums[idx]);

        // 안 넣음
        check[idx] = false;
        findDwarf(idx + 1, cnt, sum);
    }
}
