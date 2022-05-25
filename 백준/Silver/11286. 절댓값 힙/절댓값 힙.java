import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                q.add(n);
            } else {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int min = q.poll();
                    sb.append(min).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}