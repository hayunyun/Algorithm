import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();
        String ans = "";

        while (n > 0) {
            int mod = n % b;
            String add;
            n /= b;
            if (mod >= 10) {
                add = String.valueOf((char)(mod + 55));
            }
            else {
                add = String.valueOf(mod);
            }
            ans = add + ans;
        }

        System.out.println(ans);
    }
}
