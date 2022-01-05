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
        int[] nums = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int min = 1000001;
        int max = -1000001;
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i]<min)
                min = nums[i];
            if (nums[i]>max)
                max = nums[i];
        }
        bw.write(min + " " + max);
        bw.flush();
    }
}