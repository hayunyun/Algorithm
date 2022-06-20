import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (ans==sc.nextInt()) cnt++;
        }
        System.out.println(cnt);
    }
}
