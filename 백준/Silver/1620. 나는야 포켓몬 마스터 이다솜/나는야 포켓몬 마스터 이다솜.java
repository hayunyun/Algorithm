import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        HashMap<String, Integer> map = new HashMap<>();
        String[] poketmons = new String[n+1];

        for (int i = 1; i <= n; i++) {
            String mon = br.readLine();
            map.put(mon, i);
            poketmons[i] = mon;
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                sb.append(poketmons[Integer.valueOf(s)]);
            }
            else {
                sb.append(map.get(s));
            }
            sb.append("\n");
        }            
        System.out.println(sb);
    }
}