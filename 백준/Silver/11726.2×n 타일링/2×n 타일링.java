import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] Dy;
    static void preprocess(int n) {
        Dy = new int[n+1];
        Dy[1] = 1;
        Dy[2] = 2;
        for (int i = 3; i < Dy.length; i++) {
            Dy[i] = (Dy[i-2] + Dy[i-1]) % 10007;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N==1) System.out.print(1);
        else {
            preprocess(N);
            System.out.print(Dy[N]);
        }
    }
}
