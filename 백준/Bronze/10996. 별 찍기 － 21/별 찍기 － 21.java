import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean check = false;

        for (int i = 1; i <= n * 2; i++) {
            for (int j = 1; j <= n; j++) {
                if (i%2 == 0 && j==1) {
                    sb.append(" ");
                    continue;
                }
                if (!check) {
                    sb.append("*");
                    check = !check;
                }
                else {
                    sb.append(" ");
                    check = !check;
                }
            }
            sb.append("\n");
            check = false;
        }
        System.out.println(sb);
    }
}