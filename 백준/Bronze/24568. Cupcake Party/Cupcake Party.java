import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = a*8 + b*3 - 28;
        System.out.println(ans);

        sc.close();
    }
}
