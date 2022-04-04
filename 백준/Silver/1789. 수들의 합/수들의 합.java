import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());

        long sum = 0;
        int add = 1;
        int cnt = 0;
        while(sum <= n) {
            sum += add;
            add++;
            cnt++;
        }

        System.out.println(sum > n ? cnt - 1 : cnt);
    }
}