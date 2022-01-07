import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int num = Integer.parseInt(br.readLine());
        while (num != 0) {
            String ans = "";
            String n = String.valueOf(num);
            String[] org = n.split("");
            for (int i=org.length-1; i>=0; i--) {
                ans += org[i];
            }
            if (n.equals(ans)) 
                bw.write("yes");
            else
                bw.write("no");
            bw.write("\n");
            bw.flush();
            num = Integer.parseInt(br.readLine());
        }
    }
}