import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chs = br.readLine().toCharArray();
        char c = chs[0];
        int zero = 0, one = 0;
        for (int i = 1; i < chs.length; i++) {
            if (c != chs[i]) {
                if (chs[i] == '0') {
                    one++;
                } else {
                    zero++;
                }
            }

            if (i == chs.length - 1) {
                if (chs[i] == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            c = chs[i];
        }

        System.out.println(Math.min(zero, one)); // 0, 1 덩어리 중 더 작은 것을 뒤집는다
    }
}
