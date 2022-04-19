import java.io.*;
import java.util.*;

public class Main {
    static int [][] paper;
    static int white = 0 , blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkSame(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void checkSame(int x, int y, int size) {
        int sum = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += paper[i][j];
            }
        }

        if (sum == 0) {
            white++;
            return;
        }
        else if (sum == size * size) {
            blue++;
            return;
        }

        int newSize = size / 2;
        checkSame(x, y, newSize); // 1
        checkSame(x, y + newSize, newSize); // 2
        checkSame(x + newSize, y, newSize); // 3
        checkSame(x + newSize, y + newSize, newSize); // 4
    }
}