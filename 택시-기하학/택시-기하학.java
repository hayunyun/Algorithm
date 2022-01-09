import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int R = Integer.parseInt(br.readLine());
        double ans1 = R*R*Math.PI;
        double ans2 = R*(R*2);
        bw.write(String.format("%.6f", ans1) + "\n" + String.format("%.6f", ans2));
        bw.flush();
    }
}