import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> listen = new HashSet<String>();
        ArrayList<String> listenHear = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listen.add(br.readLine());
        }

        while (m-- > 0) {
            String s = br.readLine();
            if (listen.contains(s))
                listenHear.add(s);
        }

        listenHear.sort((s1, s2) -> (s1).compareTo(s2));
        bw.write(listenHear.size()+"\n");

        for (String name : listenHear) {
            bw.write(name+"\n");
        }
        bw.flush();
        bw.close();
    }
}