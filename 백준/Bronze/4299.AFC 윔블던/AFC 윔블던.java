import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int x, y;
        x = (A + B)/2;
        y = A - x;

        if (x<0 || y<0 || A < B)
            bw.write(String.valueOf(-1));
        else if (x>y && x+y==A && x-y==B)
            bw.write(x + " " + y);
        else if (y>x && x+y==A && x-y==B)
            bw.write(y + " " + x);
        else if (x==y && x+y==A && x-y==B)
            bw.write(y + " " + x);
        else
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
    }
}