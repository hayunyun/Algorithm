import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) / 4;
        while (n-- > 0) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}