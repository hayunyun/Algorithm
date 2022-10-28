import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long high;
    static long[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        nums = new long[n];
        st = new StringTokenizer(br.readLine());
        high = -1;
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
            if (nums[i] > high) high = nums[i];
        }
        
        System.out.println(binarySearch(m));
    }

    // upper bound
    static long binarySearch(long m) {
        long low = 0;
        long mid;
        while (low < high) {
            mid = (low + high) / 2;

            // 나무 잘라보기
            long sum = 0;
            for (long tree : nums) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            // 적어도 m미터 -> sum이 m보다는 커야 함
            // sum == m일 경우에는, 최대한 적게 자르기 위해 low를 높인다
            if (sum >= m) {
                low = mid + 1; // sum >= M -> 더 위로 잘라서 잘린나무 총합 줄인다
            } else {
                high = mid; // sum < M -> 더 아래로 잘라서 잘린나무 총합 늘린다
            }
        }

        return low - 1; // upper bound로 나온 값 - 1
    }
}
