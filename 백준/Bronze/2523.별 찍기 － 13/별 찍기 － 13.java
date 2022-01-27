import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= 2*n-1; i++) {
            if (i<=n)
                bw.write("*".repeat(i));
            else
                bw.write("*".repeat(2*n-i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}