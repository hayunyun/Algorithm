import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt() + sc.nextInt();
        int chicken = sc.nextInt();

        if (total >= chicken * 2) {
            System.out.println(total - chicken * 2);
        }
        else System.out.println(total);
    }
}
