import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void star(int x, int y, int N, boolean blank) {
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;
        int cnt = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                cnt++;
                if (cnt == 5) {
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}