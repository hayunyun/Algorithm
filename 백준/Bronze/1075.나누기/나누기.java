import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N / 100 * 100;
        while (true) {
            if (N % F == 0) break;
            N += 1;
        }
        System.out.println(N%100 < 10 ? "0" + N%100 : N%100);
    }
}
