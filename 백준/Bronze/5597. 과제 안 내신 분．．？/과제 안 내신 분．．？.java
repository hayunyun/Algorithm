import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            arr[n] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (!arr[i]) System.out.println(i);
        }


//        System.out.println(sb);
    }
}
