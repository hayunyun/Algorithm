import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            sb.append((chars.length >= 6 && chars.length <= 9) ? "yes" : "no");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
