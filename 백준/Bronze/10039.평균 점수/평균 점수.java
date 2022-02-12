import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int a = Integer.max(Integer.parseInt(br.readLine()), 40);
        int b = Integer.max(Integer.parseInt(br.readLine()), 40);
        int c = Integer.max(Integer.parseInt(br.readLine()), 40);
        int d = Integer.max(Integer.parseInt(br.readLine()), 40);
        int e = Integer.max(Integer.parseInt(br.readLine()), 40);
        bw.write(String.valueOf((a+b+c+d+e)/5));
        bw.flush();
        bw.close();
    }
}