import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int ans1 = Integer.parseInt(st.nextToken());
        int ans2 = Integer.parseInt(st.nextToken());
        ans1 = (ans1%10) * 100 + (ans1/10%10) * 10 + (ans1/100);
        ans2 = (ans2%10) * 100 + (ans2/10%10) * 10 + (ans2/100);
        if (ans1>ans2)
            bw.write(String.valueOf(ans1));
        else 
            bw.write(String.valueOf(ans2));
        bw.flush();
    }
}