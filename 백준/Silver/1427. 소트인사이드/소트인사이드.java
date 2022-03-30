import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        String[] s = br.readLine().split("");
        Arrays.sort(s, (s1, s2) -> s2.compareTo(s1));

        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        System.out.println(sb);
    }
}