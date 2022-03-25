import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int change = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int total = 0;

        for (int i = 0; i < coins.length; i++) {
            if (change / coins[i] > 0) {
                total += change / coins[i];
                change %= coins[i];
            }
        }
        
        System.out.println(total); 
    }
}