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
        loop1:
        for (int j = 0; j < 9; j++) {
            total -= nums[j];
            for (int i = 0; i < 9; i++) {
                if (i == j) continue;
                total -= nums[i];
                if (total == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k ==j || k ==i) continue;
                        sb.append(nums[k]).append("\n");
                    }
                    break loop1;
                }
                total += nums[i];
            }
            total += nums[j];
        }
        System.out.println(sb);
    }
}