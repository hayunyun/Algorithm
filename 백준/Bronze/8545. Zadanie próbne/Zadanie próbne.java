import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
        sc.close();
    }
}
