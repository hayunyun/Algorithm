import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  

        int L = Integer.parseInt(br.readLine()); // 방학
        int A = Integer.parseInt(br.readLine()); // 국
        int B = Integer.parseInt(br.readLine()); // 수
        int C = Integer.parseInt(br.readLine()); // 국어 하루에 푸는양
        int D = Integer.parseInt(br.readLine()); // 수학 하루에 푸는양

        int guk = A%C==0 ? A/C : A/C + 1;
        int su = B%D==0 ? B/D : B/D + 1;

        int ans = L - Integer.max(guk, su);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}