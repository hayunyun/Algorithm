import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<2*N; i++) {
            if (i<N){
                bw.write(" ".repeat(i-1) + "*".repeat(2*N-1-(i-1)*2));
                bw.write("\n");
            }
            else if (i>N) {
                bw.write(" ".repeat(2*N-1-i) + "*".repeat(2*N-1-(2*N-1-i)*2));
                bw.write("\n");
            }
            else {
                bw.write(" ".repeat(i-1) + "*");
                bw.write("\n");
            }
        }
        bw.flush();
    }
}