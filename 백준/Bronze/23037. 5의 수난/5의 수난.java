import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), 5);
        }

        System.out.println(ans);
    }
}
