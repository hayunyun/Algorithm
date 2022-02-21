import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();

        String x1 = x.toString();
        String y1 = y.toString();

        BigInteger conX = new BigInteger(x1, 2);
        BigInteger conY = new BigInteger(y1, 2);

        BigInteger sum = conX.add(conY);

        String ans = sum.toString(2);
        System.out.println(ans);
    }
}