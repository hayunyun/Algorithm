import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int cnt = 1;
        int tmp = 10;

        for (int i = 1; i <= n; i++) {
            if (i % tmp == 0) {
                cnt++;
                tmp *= 10;
            }
            ans += cnt;
        }

        System.out.println(ans);
    }
}
