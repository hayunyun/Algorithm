import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strs = new String[s.length()];
        strs[0] = String.valueOf(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            strs[s.length() - 1 - i] = s.charAt(i) + strs[s.length() - 2 - i];
        }

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();
        for (String str : strs)
            sb.append(str).append("\n");
        System.out.println(sb);

    }
}