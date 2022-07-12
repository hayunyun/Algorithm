import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            while (min != 0) {
                int ans = max % min;
                max = min;
                min = ans;
            }
            sb.append(a * b / max).append("\n");
        }
        System.out.println(sb);
    }
}