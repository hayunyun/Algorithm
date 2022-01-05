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
        String X = br.readLine();
        String[] ans = X.split("");
        int sum = 0;
        for (int i=0; i<N; i++){
            sum += Integer.parseInt(ans[i]);
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}