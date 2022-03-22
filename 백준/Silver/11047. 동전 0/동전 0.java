import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer [] coins = new Integer[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            Integer coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        Arrays.sort(coins, Collections.reverseOrder()); // 금액 높은 순으로 내림차순 정렬

        for (int i = 0; i < n; i++) {
            if (coins[i] > k) continue;
            int cnt = k / coins[i];
            total += cnt;
            k -= cnt * coins[i];
            if (k <= 0) break;
        }

        System.out.println(total);

    }
}