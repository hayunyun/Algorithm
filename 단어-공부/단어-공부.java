import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String S = br.readLine();
        S = S.toUpperCase();
        int[] apb = new int [26];
        for (int i=0; i<S.length(); i++) {
            apb[S.charAt(i) - 65] += 1;
        }
        int cnt = 0;
        int max = -1;
        char ans = ' ';
        for (int j=0; j<apb.length; j++) {
            if (max == apb[j]) {
                ans = '?';
            }
            if (max < apb[j]) {
                max = apb[j];
                cnt = j;
                ans = (char)(cnt+65);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}