import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n-1; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i*2-1; j++) {
                if (j%2==0)
                    sb.append(" ");
                else
                    sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
