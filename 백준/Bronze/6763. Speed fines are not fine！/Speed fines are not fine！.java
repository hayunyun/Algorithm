import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int speed = b - a;
        if (speed <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        }
        else {
            if (1 < speed && speed <= 20) {
                System.out.println("You are speeding and your fine is $100.");
            }
            else if (21 < speed && speed <= 30) {
                System.out.println("You are speeding and your fine is $270.");
            }
            else {
                System.out.println("You are speeding and your fine is $500.");
            }
        }
    }
}
