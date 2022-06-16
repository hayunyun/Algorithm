import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = sc.next();
        String f = ":fan:";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==1 && j==1) sb.append(":").append(s).append(":");
                else sb.append(f);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
