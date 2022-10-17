import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        int a = strs.charAt(0) - '0';
        int b = strs.charAt(4) - '0';
        int c = strs.charAt(8) - '0';
        System.out.println((a+b == c) ? "YES" : "NO");
    }

}
