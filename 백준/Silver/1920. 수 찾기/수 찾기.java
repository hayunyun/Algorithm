import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int num) {
        int low = 0;
        int high = n-1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (num < nums[mid]) {
                high = mid - 1;
            } else if (num > nums[mid]) {
                low = mid + 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
