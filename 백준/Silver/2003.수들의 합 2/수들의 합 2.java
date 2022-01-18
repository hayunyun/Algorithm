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
        int[] nums = new int[N+1]; // 투포인터 쓸 때 더 편하게 1을 더해줌
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0, sum = nums[0], low = 0, high = 0;

        while (low < N && high < N) {
            // sum == M -> 답 low++
            if (sum==M) {
                cnt++;
                sum -= nums[low++]; // sum에서 low에 해당하는 값을 빼고 low를 1 증가
            }
            // sum > M -> low++ (현재 sum을 작게 만들기)
            else if (sum > M) {
                sum -= nums[low++];
            }
            // sum < M -> high++ (현재 sum을 크게 만들기) 
            // !! 여기때문에 배열크기를 N+1으로 설정함. high가 1 올라갔을때 인덱스에러가 뜨지 않게 하기위해 (0이므로 합에는 지장없다)
            else {
                sum += nums[++high]; // high를 먼저 1 증가시키고 그 값을 sum에 넣어줌
            }
            
            if (high == N) { // high가 배열 안의 값을 넘으면 (배열크기가 N+1이므로, 인덱스가 N이면 빈 부분에 도착함)
                break;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}