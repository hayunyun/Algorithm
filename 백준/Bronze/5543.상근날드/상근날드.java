import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int minBurger = Integer.min(a, b);
        minBurger = Integer.min(minBurger, c);
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(minBurger + Integer.min(d, e) - 50));
        bw.flush();
        bw.close();
    }
}