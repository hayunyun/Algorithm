import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1]; // 투포인터 쓸 때 더 편하게 1을 더해줌
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int length = N+1, sum = nums[0], low = 0, high = 0;

        while (low < N && high < N) {
            // sum < S
            if (sum < S) {
                sum += nums[++high];
                // bw.write("low: " + low + ", high: " + high + ", sum: " + sum + ", length: " + length + "\n");
            }
            // sum >= S
            else {
                if (sum >= S && high - low + 1 < length)
                    length = high - low + 1;
                sum -= nums[low++];
                // (의 최소길이)
                // bw.write("low: " + low + ", high: " + high + ", sum: " + sum + ", length: " + length + "\n");
            }
        }

        if (length==N+1)
            bw.write(String.valueOf(0));
        else
            bw.write(String.valueOf(length));

        bw.flush();
    }
}