import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        whatNumber(n, k);
    }

    static void whatNumber(int n, int k) {
        boolean[] check = new boolean[n+1];
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (check[j]) continue;
                check[j] = true;
                cnt++;
                if (cnt == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
