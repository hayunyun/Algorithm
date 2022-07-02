import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str == null) break;

            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken()) + 1;
            int s = Integer.parseInt(st.nextToken());

            if (n > s) {
                sb.append(0);
            }
            else {
                sb.append(s / n);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}