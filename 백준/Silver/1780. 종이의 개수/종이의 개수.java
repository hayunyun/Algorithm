import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, minus = 0, zero = 0, plus = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void count(int r, int c, int size) {
        if (isSame(r, c, size)) {
            if (map[r][c] == -1) {
                minus++;
            } else if (map[r][c] == 0) {
                zero++;
            } else if (map[r][c] == 1) {
                plus++;
            }
        } else {
            // 9분할
            size /= 3;

            count(r, c, size);
            count(r, c + size, size);
            count(r, c + size * 2, size);

            count(r + size, c, size);
            count(r + size, c + size, size);
            count(r + size, c + size * 2, size);

            count(r + size * 2, c, size);
            count(r + size * 2, c + size, size);
            count(r + size * 2, c + size * 2, size);
        }
    }

    static boolean isSame(int r, int c, int size) {
        int first = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != first) return false;
            }
        }

        return true;
    }
}
