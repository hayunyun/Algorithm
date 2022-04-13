import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] names = br.readLine().split("-");
        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            sb.append(name.charAt(0));
        }

        System.out.println(sb);

    }
}