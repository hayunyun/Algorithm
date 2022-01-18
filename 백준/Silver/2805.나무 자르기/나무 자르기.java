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
        long M = Long.parseLong(st.nextToken());
        long[] trees = new long[N];
        
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            if (trees[i] > max) 
                max = trees[i];
        }
        
        long low = 0, high = max, mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            long sum = 0;
            for (long tree : trees) {
                if (tree > mid)
                    sum += tree - mid;
            }
            // sum < M -> 더 아래로 자르기
            if (sum < M) { 
                high = mid - 1;
            }
            // sum >= M -> 더 위로 자르기
            else {
                low = mid + 1;
            }
        }

        bw.write(String.valueOf(high));
        bw.flush();

    }
}