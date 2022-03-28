import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        
        ArrayList<Integer> S = new ArrayList<>();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String mtd = st.nextToken();
            int x = 0;
            if (!(mtd.equals("all") || mtd.equals("empty"))) x = Integer.parseInt(st.nextToken());
            switch(mtd) {
                case "add":
                    S.add(x);
                    break;
                case "remove":
                    S.remove(Integer.valueOf(x));
                    break;
                case "check":
                    if (S.contains(x)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle":
                    if (S.contains(x)) S.remove(Integer.valueOf(x));
                    else S.add(x);
                    break;
                case "all":
                    S.clear();
                    for (int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}