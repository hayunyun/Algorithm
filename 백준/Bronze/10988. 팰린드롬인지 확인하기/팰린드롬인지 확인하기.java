import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(check(str));
    }

    static int check (String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return 0;
        }
        return 1;
    }
}
