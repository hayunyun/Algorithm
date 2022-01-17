import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        String S = br.readLine();
        String F = br.readLine();
        for (int i=0; i<S.length(); i++) {
            int n = i;
            while (n>=F.length())
                n = n - F.length();
            int ans = S.charAt(i) - F.charAt(n);
            if (S.charAt(i)==' ') ans = S.charAt(i);
            else if (ans<=0)
                ans += 'z';
            else
                ans += 'a' - 1;
            bw.write((char)ans);
        }
        bw.write( "\n");
        bw.flush();
    }
}