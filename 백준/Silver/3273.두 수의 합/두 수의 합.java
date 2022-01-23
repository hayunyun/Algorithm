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
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int sum = 0, cnt = 0;
        int start = 0, end = N-1;

        while (start < end) {
            sum = nums[start] + nums[end];
            // sum == X -> start++
            if (sum == X) {
                cnt++;
                sum -= nums[start++]; // start 원래값을 빼고 옆으로 한칸 이동
            }
            // sum < X -> start++
            else if (sum < X) {
                sum -= nums[start++];
            }
            // sum > X -> end--
            else if (sum > X) {
                sum -= nums[end--];
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}