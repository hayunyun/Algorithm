import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 1;
        boolean checkL = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') cnt++;
            else if (s.charAt(i) == 'L') {
                if (checkL) cnt++;
                checkL = !checkL;
            }
        }

        System.out.println(cnt > n ? n: cnt);
    }
}