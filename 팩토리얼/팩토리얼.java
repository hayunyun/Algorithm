import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        int cnt = 1;
        while (N != 0) {
            ans *= cnt; 
            cnt++;
            if (cnt>N)
                break;
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}