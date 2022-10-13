import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    static long n, k, ja, mo;
    static final int num = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Long.parseLong(st.nextToken());
            k = Long.parseLong(st.nextToken());

            // 분자 N!
            ja = fact(n);

            // 분모 (K! * (N-K)!) mod p
            mo = fact(k) * fact(n - k) % num;

            // N! * 분모의 역원((K! * (N-K)!)
            sb.append("#" + tc + " " + (ja * pow(mo, num - 2) % num) + "\n");
        }
        System.out.println(sb);
    }

    public static long fact(long N) {
        long fac = 1L;

        while(N > 1) {
            fac = (fac * N) % num;
            N--;
        }
        return fac;
    }

    public static long pow(long base, long expo) {
        if(expo == 1) {
            return base % num;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % num) * base % num;
        }
        return temp * temp % num;
    }

}