import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int total = 0;
        int exer = 0;
        int now = m;
        while (exer != N) {
            if (now + T <= M) {
                now += T;
                total += 1;
                exer += 1;
            }
            else {
                if (now - R < m) now = m;
                else now -= R;
                total += 1;
            }

            if (now + T > M & now == m) {
                total = -1;
                break;
            }
        }
        System.out.println(total);
    }
}
