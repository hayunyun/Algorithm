import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while (a!=0 && b!=0 && c!=0) {
            if (c>a && c>b) {
                if (a*a + b*b == c*c)
                    bw.write("right");
                else
                    bw.write("wrong");
            }
            else if (b>a && b>c) {
                if (a*a + c*c == b*b)
                    bw.write("right");
                else
                    bw.write("wrong");
            }
            else if (a>b && a>c) {
                if (c*c + b*b == a*a)
                    bw.write("right");
                else
                    bw.write("wrong");
            }
            bw.write("\n");
            bw.flush();
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
