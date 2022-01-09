import java.io.*;
import java.util.*;

public class Main {
    public static int fibo(int N) {
        int cnt = 0;
        int ans = 0;
        if (N==cnt) return ans;
        if (N==0) {
            ans = 0;
            cnt++;
        }
        else if (N==1) {
            ans = 1;
            cnt++;
        }
        else {
            ans = fibo(N-2) + fibo(N-1);
            cnt++;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());   
        bw.write(fibo(N) + "\n");
        bw.flush();
    }
}