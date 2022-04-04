import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n/2 * 2; i++) {
            sb.append((i % 2 == 1) ? 1 : 2).append(" ");
        }

        if (n % 2 != 0)
            sb.append(3);

        System.out.println(sb);
    }
}