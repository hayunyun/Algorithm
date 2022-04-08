import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n];
        arr = new int[m];

        backTracking(0, 0);
        System.out.println(sb);
    }

    public static void backTracking(int cnt, int value) {
        if (cnt == m) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = value; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[cnt] = i + 1;
                backTracking(cnt + 1, i + 1);
                check[i] = false;
            }
        }
    }
}