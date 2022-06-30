import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int total = rev(a) + rev(b);
        System.out.println(rev(total));
    }

    static int rev(int x) {
        int result = 0;
        while (x > 0) {
            result += x % 10;
            if (x >= 10) result *= 10;
            x /= 10;
        }
        return result;
    }
}
