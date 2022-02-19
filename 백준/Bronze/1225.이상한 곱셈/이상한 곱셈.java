import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        String y = st.nextToken();
        long ans = 0;

        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < y.length(); j++) {
                ans += (Long.valueOf(x.charAt(i)) - '0') * (Long.valueOf(y.charAt(j)) - '0');
            }
        }
        System.out.println(ans);
    }
}