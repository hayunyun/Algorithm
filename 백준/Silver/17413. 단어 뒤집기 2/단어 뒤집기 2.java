import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String add = "";
        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                check = true;
                sb.append(add).append(c);
                add = "";
            }
            else if (check) {
                if (c == '>') check = false;
                sb.append(c);
            }
            else if (i == s.length() - 1) {
                add = c + add;
                sb.append(add);
            }
            else if (c == ' ') {
                sb.append(add).append(c);
                add = "";
            }
            else {
                add = c + add;
            }
        }

        System.out.println(sb);
    }
}