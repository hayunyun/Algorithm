import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int sum = 0;
        int low = 0, high = 0;

        while (low < N && high < N) {
            if (low == high)
                sum = nums[low];
            else {
                sum = 0;
                for (int i=low; i<=high; i++) {
                    sum += nums[i];
                }
            }

            if (sum==M && low < high) {
                cnt++;
                low++;
                // bw.write("cnt++ & 현재값: " + cnt + "\n");
            }
            else if (sum==M && low == high) {
                cnt++;
                high++;
                // bw.write("cnt++ & 현재값: " + cnt + "\n");
            }
            else if (sum < M) {
                high++;
            }
            else if (sum > M) {
                low++;
            }
            // bw.write("low: " + low + ", high: " + high + "\n");
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}