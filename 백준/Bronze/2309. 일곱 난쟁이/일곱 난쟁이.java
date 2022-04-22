import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[9];
        ArrayList<Integer> ans = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            total += nums[i];
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        int spyA = 0, spyB = 0;
        loop1:
        for (int j = 0; j < 8; j++) {
            for (int i = 1; i < 9; i++) {
                if (total - nums[j] - nums[i] == 100) {
                    spyA = i;
                    spyB = j;
                    break loop1;
                }
            }
        }

        for (int k = 0; k < 9; k++) {
            if (k == spyA || k == spyB) continue;
            sb.append(nums[k]).append("\n");
        }
        System.out.println(sb);
    }
}