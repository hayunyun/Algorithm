import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        int[] ans = new int[s1 + s2 + s3 + 1];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int z = 1; z <= s3; z++) {
                    ans[i + j + z] += 1;
                }
            }
        }

        int max = ans[0];
        int maxIdx = 0;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] > max) {
                max = ans[i];
                maxIdx = i;
            }
        }
        
        System.out.println(maxIdx);
    }
}
