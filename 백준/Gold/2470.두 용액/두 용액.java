import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(nums);
        int start = 0, end = N - 1;
        long sum = 0;
        
        long[] ans = new long[2];
        ans[0] = nums[start];
        ans[1] = nums[end];
        
        while (start<end) {
            sum = nums[start] + nums[end];
            // 공통적으로, 현재 최솟값보다 0 에 가까우면 답 교체
            if (Math.abs(ans[0]+ans[1]) > Math.abs(sum)) {
                ans[0] = nums[start];
                ans[1] = nums[end];
                // System.out.println("change " + nums[start] + " " + nums[end] + "= " + (nums[start] + nums[end]));
            }
            
            // 1. sum < 0 -> start ++
            if (sum < 0) {
                start++;
            }
            // 2. sum > 0 -> end --
            else if (sum > 0) {
                end--;
            }
            // 3. sum == 0 -> break
            else {
                ans[0] = nums[start];
                ans[1] = nums[end];
                break;
            }
        }
        
        bw.write(ans[0] + " " + ans[1]);
        bw.flush();
    }
}