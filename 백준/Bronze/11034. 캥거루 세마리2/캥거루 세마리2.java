import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] abc = scanner.nextLine().split(" ");
            int A = Integer.parseInt(abc[0]);
            int B = Integer.parseInt(abc[1]);
            int C = Integer.parseInt(abc[2]);
            int AB = B - A - 1;
            int CB = C - B - 1;
            System.out.println(Math.max(AB, CB));
        }
    }
}