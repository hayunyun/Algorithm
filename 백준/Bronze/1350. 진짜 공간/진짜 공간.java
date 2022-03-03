import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        long cnt = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        int clst = Integer.parseInt(br.readLine());

        for (long num : nums) {
            if (num == 0) continue;
            cnt += num / clst + (num % clst == 0 ? 0 : 1);
        }

        System.out.println(clst * cnt);
    }
}