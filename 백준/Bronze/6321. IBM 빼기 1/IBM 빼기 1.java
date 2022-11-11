import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb.append("String #").append(tc).append("\n");
            char[] strs = br.readLine().toCharArray();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] < 'Z') {
                    sb.append((char)(strs[i] + 1));
                } else {
                    sb.append("A");
                }
            }
            sb.append("\n\n");
        }
        
        System.out.println(sb);
    }
}
