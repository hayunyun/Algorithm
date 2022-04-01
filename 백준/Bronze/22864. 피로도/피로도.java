import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        int status = 0;
        int hour = 0;

        while (hour < 24) {
            if (status + a <= m) {
                status += a;
                ans += b;
            }
            else {
                status = (status - c < 0 ? 0 : status - c);
            }
            hour++;
        }
        
        System.out.println(ans);
    }
}