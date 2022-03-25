import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int change = 1000 - Integer.parseInt(br.readLine());
        int total = 0;

        while (change != 0) {
            if (change >= 500) {
                total += change / 500;
                change %= 500;
            }
            else if (change >= 100) {
                total += change / 100;
                change %= 100;
            }
            else if (change >= 50) {
                total += change / 50;
                change %= 50;
            }
            else if (change >= 10) {
                total += change / 10;
                change %= 10;
            }
            else if (change >= 5) {
                total += change / 5;
                change %= 5;
            }
            else if (change >= 1) {
                total += change / 1;
                change %= 1;
            }
        }
        System.out.println(total); 
    }
}