import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(x)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int binarySearch(int x) {
        int low = 0;
        int high = n-1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (x < nums[mid]) {
                high = mid - 1;
            } else if (x > nums[mid]) {
                low = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
