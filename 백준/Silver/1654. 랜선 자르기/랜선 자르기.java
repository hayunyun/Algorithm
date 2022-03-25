import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lines = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long lo = 0;
        long hi = max + 1;
        long mid = 0;
        while(lo < hi) {
            long sum = 0;
            mid = (lo + hi) / 2;
            for (int i = 0; i < lines.length; i++) {
                sum += lines[i] / mid;
                if (sum > n) break;
            }
            if (sum < n) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }

}