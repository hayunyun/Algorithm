import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int total = 1;
        int cnt = 1;
        while (n > total) {
            total += 6 * cnt++;
        }

        System.out.println(cnt);
    }
}
