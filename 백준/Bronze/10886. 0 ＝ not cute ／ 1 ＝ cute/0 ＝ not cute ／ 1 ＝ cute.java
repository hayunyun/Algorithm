import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score = 0;
        for (int i = 0; i < n; i++) {
            int vote = sc.nextInt();
            if (vote == 1) score++;
            else score--;
        }

        if (score > 0)
            System.out.println("Junhee is cute!");
        else
            System.out.println("Junhee is not cute!");
    }
}
