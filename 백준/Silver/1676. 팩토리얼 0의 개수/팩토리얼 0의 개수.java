import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int ans = 0;

        while (t >= 5) {
            ans += t/5;
            t /= 5;
        }
        
        // 소인수분해 했을 때 5의 개수만큼 0의 개수 증가
        System.out.println(ans);
    }
}