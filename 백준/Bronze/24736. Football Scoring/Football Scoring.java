import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int ans = a*6 + b*3 + c*2 + d + e*2;
            System.out.println(ans);
        }

        sc.close();
    }
}
