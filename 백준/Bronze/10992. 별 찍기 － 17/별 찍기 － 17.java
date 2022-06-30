import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i==n) {
                for (int j = 1; j <= i*2-1; j++) {
                    sb.append("*");
                }
                sb.append("\n");
                break;
            }

            for (int j = i; j <= n-1; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i*2-1; j++) {
                if (j==1 || j==i*2-1)
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
