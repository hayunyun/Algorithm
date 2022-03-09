import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String [] strs;
        for (int i = 0; i < N; i++) {
            strs = br.readLine().split(" ");
            for (int j = 0; j < strs.length; j++) {
                for (int j2 = strs[j].length() - 1; j2 >= 0 ; j2--) {
                    sb.append(strs[j].charAt(j2));
                }
                sb.append(" ");
            }
            if (i != N - 1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}