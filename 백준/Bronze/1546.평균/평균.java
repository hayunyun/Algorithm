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

        int N = Integer.parseInt(br.readLine());
        double [] arr = new double[N];
        double max = 0;
        double sum = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max<arr[i])
                max = arr[i];
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i] / max * 100 ;
            sum += arr[i];
        }
        bw.write(Math.round(sum/arr.length * 100) /100.0 + "\n");
        bw.flush();
    }
}