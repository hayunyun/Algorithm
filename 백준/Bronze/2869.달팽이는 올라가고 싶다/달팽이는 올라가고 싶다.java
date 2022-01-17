import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        double A = Integer.parseInt(st.nextToken());
        double B = Integer.parseInt(st.nextToken());
        double V = Integer.parseInt(st.nextToken());   
        int ans = (int)Math.ceil((V - A) / (A - B)) + 1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}