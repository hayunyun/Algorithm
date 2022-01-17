import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<2*N; i++) {
            if (i<=N){
                bw.write(" ".repeat(N-i) + "*".repeat(2*i-1));
                bw.write("\n");
            }
            else {
                bw.write(" ".repeat(i%N) + "*".repeat((2*N-i)*2-1));
                bw.write("\n");
            }
        }
        bw.flush();
    }
}