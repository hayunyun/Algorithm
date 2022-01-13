import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int T = Integer.parseInt(br.readLine());
        for (int j=0; j<T; j++) {
            int M = Integer.parseInt(br.readLine());
            
            boolean[] prime = new boolean[M+1];
            
            prime[0] = true;
            prime[1] = true;
    
            for (int i=2; i<=Math.sqrt(M); i++) { 
                if (prime[i]) continue;
                for (int z = i+i; z<prime.length; z+=i) {
                    prime[z] = true;
                }
            }

            ArrayList<Integer> nums = new ArrayList<>();
    
            for (int i=0; i<M; i++) {
                if (!prime[i]) {
                    nums.add(i);
                }
            }

            for (int i=M/2; i>1; i--) {
                if (nums.contains(i)) {
                    if (nums.contains(M-i)){
                        bw.write(i + " " + (M-i) + "\n");
                        break;
                    }
                }
            }
            bw.flush();
        }
    }
}