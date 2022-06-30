import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] b = new int[k][l];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ans = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                for (int o = 0; o < m; o++) {
                    ans[i][j] += a[i][o] * b[o][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
