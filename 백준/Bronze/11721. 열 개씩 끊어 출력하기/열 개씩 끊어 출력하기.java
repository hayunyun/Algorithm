import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int cnt = 1;
        for (int i = 0; i <s.length(); i++) {
            if (cnt > 10) {
                sb.append("\n");
                cnt = 1;
            }
            sb.append(s.charAt(i));
            cnt++;
        }

        System.out.println(sb);
    }
}