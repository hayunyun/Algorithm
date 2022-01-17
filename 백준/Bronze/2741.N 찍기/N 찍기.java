import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        StringTokenizer st; // 여러개를 입력받아 사용할 때
        
        int N = Integer.parseInt(br.readLine()); //Int

        for (int i=1; i<=N; i++) {
            bw.write(String.valueOf(i+"\n"));
        }
        bw.flush();
    }
}