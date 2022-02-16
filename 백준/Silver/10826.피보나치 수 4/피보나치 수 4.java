import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger[] dp;
    static int N;
    static void fibo() {
        dp = new BigInteger[N+1];
        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N==0) System.out.print(0);
        else {
            fibo();
            System.out.print(dp[N]);
        }
    }
}
