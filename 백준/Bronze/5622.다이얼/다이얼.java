import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String S = br.readLine();
        int sum = 0;
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i) <= 67)
                sum += 3;
            else if (S.charAt(i) <= 70)
                sum += 4;
            else if (S.charAt(i) <= 73)
                sum += 5;
            else if (S.charAt(i) <= 76)
                sum += 6;
            else if (S.charAt(i) <= 79)
                sum += 7;
            else if (S.charAt(i) <= 83)
                sum += 8;
            else if (S.charAt(i) <= 86)
                sum += 9;
            else 
                sum += 10;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}