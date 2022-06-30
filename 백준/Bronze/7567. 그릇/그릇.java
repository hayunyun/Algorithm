import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int ans = 10;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1))
                ans += 5;
            else ans += 10;
        }
        System.out.println(ans);
    }
}
