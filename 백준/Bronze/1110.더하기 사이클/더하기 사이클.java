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
        int origin = N;
        int count = 0;
        while (true) {
            int A = N / 10;
            int B = N % 10;
            N = B * 10 + ((A + B) % 10);
            count += 1;
            if (origin==N) 
                break;
        }
        bw.write(count +"\n");
        bw.flush();
    }
}