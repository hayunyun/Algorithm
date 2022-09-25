import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            if (chars[i] != '5') {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
