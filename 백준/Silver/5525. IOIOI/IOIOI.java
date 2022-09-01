import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] strs = br.readLine().toCharArray();
        
        int ans = 0, cnt = 0;
        int i = 0;
        while (i < m - 1) {
            if (i < m - 2 && strs[i] == 'I' && strs[i+1] == 'O' && strs[i+2] == 'I') {
                cnt++;
                i += 2;
                if (cnt == n) {
                    ans++;
                    cnt--;
                }
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);

    }
}
