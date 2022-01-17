import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = N;

        for (int i=M; i<=N; i++) { 
            if (i != 1) {
                for (int j=2; j<=i; j++) {
                    if (i!=j && i%j == 0) 
                        break;
                    else if (i==j) {
                        sum += i;
                        if (i<min)
                            min = i;
                    }
                }
            }
        }
        if (sum==0) {
            bw.write(String.valueOf(-1));
        }
        else {
            bw.write(String.valueOf(sum) + "\n");
            bw.write(String.valueOf(min));
        }
        bw.flush();
    }
}