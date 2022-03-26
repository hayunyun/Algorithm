import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        int[] coins = {25, 10, 5, 1};
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int change = Integer.parseInt(br.readLine());
            for (int j = 0; j < coins.length; j++) {
                if (change >= coins[j]) {
                    sb.append(change / coins[j]).append(" ");
                    change %= coins[j];
                }
                else
                    sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}