import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static char[] P;
    static int K;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken().toCharArray(); // Char 배열로 받기
        K = Integer.parseInt(st.nextToken());

        boolean[] isNotPrime = new boolean[K+1]; // false가 소수

        for (int i = 2; i <= K+1; i++) {
            for (int j = 2; i*j < isNotPrime.length; j++) {
                if (isNotPrime[i*j]) 
                    continue;
                isNotPrime[i*j] = true;
                // System.out.println(i*j + " 소수 아님");
            }
        }

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                if (i >= K) break;
                if (checkIsBad(i)) {
                    System.out.println("BAD " + i);
                    return;
                }

            }
        }
        System.out.println("GOOD");

    }

    static boolean checkIsBad(int x) {
        int r = 0;
        for (int i = 0; i < P.length; i++) {
            r = (r * 10 + (P[i] - '0')) % x;
        }
        if (r == 0)
            return true;
        else
            return false; // 한번만 나와도 틀림
    }
}