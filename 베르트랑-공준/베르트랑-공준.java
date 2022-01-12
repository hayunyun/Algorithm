import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        while (true) {
            int M = Integer.parseInt(br.readLine());
            if (M==0) break;
            boolean[] prime = new boolean[2*M+1];
            int cnt = (M==1? 1 : 0);
            
            prime[0] = true;
            prime[1] = true;
            prime[M] = true;
    
            for (int i=2; i<=Math.sqrt(prime.length); i++) { 
                if (prime[i]) continue;
                for (int j = i+i; j<prime.length; j+=i) {
                    prime[j] = true;
                }
            }
    
            for (int i=M; i<2*M; i++) {
                if (!prime[i])
                    cnt++;
            }
            bw.write(cnt + "\n");    
            bw.flush();

        }
    }
}