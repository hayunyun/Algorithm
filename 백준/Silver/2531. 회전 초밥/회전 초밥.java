import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 초밥 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수 (1~d)
        int k = Integer.parseInt(st.nextToken()); // 연속 접시
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] check = new int[d+1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (check[sushi[i]] == 0) cnt++;
            check[sushi[i]]++;
        }

        int maxCnt = cnt;
        for (int i = 1; i < n; i++) {
            if (cnt >= maxCnt) {
                if (check[c] == 0) {
                    maxCnt = cnt + 1;
                } else {
                    maxCnt = cnt;
                }
//                cnt += (check[c] == 0) ? 1 : 0;
//                maxCnt = cnt;
            }

            // 가장 먹은지 오래 된 초밥 하나 빼기
            int prev = sushi[i-1];
            if (--check[prev] == 0) cnt--; // 아예 안먹은 게 되면 1 빼주기

            // 다음 초밥 하나 먹기
            int now = sushi[(i + k - 1) % n];
            if (check[now]++ == 0) cnt++; // 새로운 초밥인 경우 1 더해주기
        }

        System.out.println(maxCnt);
    }

}
