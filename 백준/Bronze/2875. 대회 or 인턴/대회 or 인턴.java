import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            if (n/2 >= m) n--;
            else m--;
        }
        System.out.println(Math.min(n/2, m));
    }
}
