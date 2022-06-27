import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            int num = sc.nextInt();
            sum += price * num;
        }

        if (sum == total)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
