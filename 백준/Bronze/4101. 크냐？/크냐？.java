import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a==0 && b==0) break;

            if (a>b) sb.append("Yes");
            else sb.append("No");

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
