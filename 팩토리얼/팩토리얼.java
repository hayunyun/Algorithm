import java.io.*;
import java.util.*;

public class Main {
    public static int fac(int N) {
        if (N<=1) return 1;
        return N*fac(N-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        bw.write(fac(N) + "\n");
        bw.flush();
    }
}
