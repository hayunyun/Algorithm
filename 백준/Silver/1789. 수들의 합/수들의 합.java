import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Long.parseLong(br.readLine());

        long sum = 0;
        int add = 0;
        while(sum <= n) {
            sum += ++add;
        }

        System.out.println(sum > n ? add - 1 : add);
    }
}