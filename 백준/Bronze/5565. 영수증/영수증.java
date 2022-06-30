import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            total -= sc.nextInt();
        }
        System.out.println(total);
    }
}
