import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (int j=0; j<S.length(); j++) {
                int cnt = R;
                while (cnt != 0) {
                    bw.write(S.charAt(j));
                    cnt--;
                }
            }
            bw.write("\n");
            bw.flush();
        }
    }
}