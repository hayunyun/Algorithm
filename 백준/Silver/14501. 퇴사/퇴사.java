import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max = Integer.MIN_VALUE;
    static int[][] schedule;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        schedule = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);
        System.out.println(max);
    }

    static void find(int idx, int res) {
        if (idx == n) {
            max = Math.max(max, res);
            return;
        }

        for (int i = idx; i < n; i++) {
            find(i + schedule[i][0], res + schedule[i][1]);
            find(i + 1, res);
        }
    }
}
