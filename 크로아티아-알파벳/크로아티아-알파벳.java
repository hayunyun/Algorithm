import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String S = br.readLine();
        int cnt = 0;
        while (S.contains("c=")) {
            S = S.replaceFirst("c=", " ");
            cnt++;
        }
        while (S.contains("c-")) {
            S = S.replaceFirst("c-", " ");
            cnt++;
        }
        while (S.contains("dz=")) {
            S = S.replaceFirst("dz=", " ");
            cnt++;
        }
        while (S.contains("d-")) {
            S = S.replaceFirst("d-", " ");
            cnt++;
        }
        while (S.contains("lj")) {
            S = S.replaceFirst("lj", " ");
            cnt++;
        }
        while (S.contains("nj")) {
            S = S.replaceFirst("nj", " ");
            cnt++;
        }
        while (S.contains("s=")) {
            S = S.replaceFirst("s=", " ");
            cnt++;
        }
        while (S.contains("z=")) {
            S = S.replaceFirst("z=", " ");
            cnt++;
        }
        S = S.replace(" ", "");
        bw.write(String.valueOf(cnt + S.length()));
        bw.flush();
    }
}