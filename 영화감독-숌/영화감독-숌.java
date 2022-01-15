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
        int cnt = 1;
        int n = 666;
        while (N!=cnt) {
            n++;
            if (String.valueOf(n).contains("666")) 
                cnt++;
        }
        bw.write((n) + "\n");
        bw.flush();
    }
}
