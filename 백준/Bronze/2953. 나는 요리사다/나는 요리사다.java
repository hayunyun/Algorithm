import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int[] total = new int[5];
        for (int i = 0; i < 5; i++) {
            total[i] = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
        }

        int max = -1;
        int who = -1;
        for (int i = 0; i < 5; i++) {
            if (max < total[i]) {
                max = total[i];
                who = i+1;
            }
        }

        System.out.println(who + " " + max);
    }
}
