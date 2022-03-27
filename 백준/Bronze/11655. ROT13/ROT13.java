import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z')
                sb.append((char)(c + 13) > 'Z' ? (char)(c - 13) : (char)(c + 13));
            else if (c >= 'a' && c <= 'z')
                sb.append((char)(c + 13) > 'z' ? (char)(c - 13) : (char)(c + 13));
            else
                sb.append(c);
        }
        System.out.println(sb);
    }
}