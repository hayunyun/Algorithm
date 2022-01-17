import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) { //입력
            int x = Integer.parseInt(st.nextToken());
            if (x!=1) {
                for (int j=2; j<=x; j++) {
                    if (x!=j && x%j == 0) {
                        break;
                    }
                    else if (x==j) {
                        cnt++;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}