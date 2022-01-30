import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(gcd(A, B) + "\n");
        bw.write(baesu(A, B) + "\n");

        bw.flush();
        bw.close();
    }

    static int gcd(int x, int y) {
        while (x%y != 0) {
            int mod = x%y;
            x = y;
            y = mod;
        }
        return y;
    }

    static int baesu(int x, int y) {
        int gcd = gcd(x, y);
        return gcd * (x/gcd) * (y/gcd);
    }
}