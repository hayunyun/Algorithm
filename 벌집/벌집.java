import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int cnt = 1;
        if (N!=1) {
            for (int i=1; sum<N; i++) {
                sum += 6*i;
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
    }
}