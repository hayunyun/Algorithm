import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();
        int tmp = 1;
        int ans = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                ans += (c - 'A' + 10) * tmp;
            }
            else {
                ans += (c - '0') * tmp;
            }
            tmp *= b;
        }

        System.out.println(ans);
    }
}
