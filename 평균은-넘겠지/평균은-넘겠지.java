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

        int C = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<C; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            int avg = sum / arr.length;
            int cnt = 0;
            for (Integer obj : arr) {
                if (obj > avg)
                    cnt++;
                }
            bw.write(String.format("%.3f", (double)cnt/arr.length * 100) + "%" + "\n");
            bw.flush();
        }
    }
}