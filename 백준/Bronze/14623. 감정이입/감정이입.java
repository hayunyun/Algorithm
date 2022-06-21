import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        String b = sc.next();

        long A = Long.parseLong(a, 2);
        long B = Long.parseLong(b, 2);

        String ans = Long.toBinaryString(A*B); // 2진수

        System.out.println(ans);
    }
}
