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
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if (A>B) {
            if (A>C) {
                if (B>C)
                    bw.write(C + " " + B + " " + A);
                else
                    bw.write(B + " " + C + " " + A);
            }
            else
                bw.write(B + " " + A + " " + C);
        }
        else { // B>A
            if (A>C) 
                bw.write(C + " " + A + " " + B);
            else { // B>A && C>A
                if (B>C)
                    bw.write(A + " " + C + " " + B);
                else
                    bw.write(A + " " + B + " " + C);
            }
        }
        bw.flush();
    }
}