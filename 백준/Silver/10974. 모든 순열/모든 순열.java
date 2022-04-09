import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int [n + 1];
        check = new boolean[n + 1];
        backTrack(1);
        System.out.println(sb);
    }

    public static void backTrack(int depth) {
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                if (depth == n) {
                    arr[depth] = i;
                    for (int z = 1; z <= n; z++)
                        sb.append(arr[z]).append(" ");
                    sb.append("\n");
                    return;
                }
                check[i] = true;
                arr[depth] = i;
                backTrack(depth + 1);
                check[i] = false;
            }
        }
    }
}