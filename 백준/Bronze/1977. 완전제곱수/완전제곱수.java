import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int x = 1;
        int sum = 0, min = Integer.MAX_VALUE;
        int ans = x * x;
        while (ans <= n) {
            if (ans >= m) {
                sum += ans;
                min = Math.min(min, ans);
            }
            x++;
            ans = x * x;
        }
        if (sum == 0) System.out.println(-1);
        else System.out.println(sum + "\n" + min);
    }
}