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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(br.readLine());

        C = C+D;
        if (C>=60) {
            B = B + C/60;
            C = C % 60;
            if (B >=60) {
                A = A + (B / 60);
                B = B % 60;
                if (A >= 24) {
                    A = A % 24;
                }
            }
        }
        bw.write(A + " " + B + " " + C);
        bw.flush();
    }
}