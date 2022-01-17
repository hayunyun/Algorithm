import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            bw.write("*".repeat(i) +"\n");
        }
        bw.flush();
    }
}