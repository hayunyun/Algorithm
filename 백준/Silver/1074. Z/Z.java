import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n2 = 1;
        for (int i = 1; i <= n; i++) n2 *= 2;

        zVisit(0, 0, n2);
        System.out.println(cnt);
    }

    static void zVisit(int x, int y, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 2;
        if (r < x + newSize && c < y + newSize){
            cnt += 0;
            zVisit(x, y, newSize);
        }
        else if (r < x + newSize && c >= y + newSize) {
            cnt += newSize * newSize * 1;
            zVisit(x, y + newSize, newSize);
        }
        else if (r >= x + newSize && c < y + newSize) {
            cnt += newSize * newSize * 2;
            zVisit(x + newSize, y, newSize);
        }
        else {
            cnt += newSize * newSize * 3;
            zVisit(x + newSize, y + newSize, newSize);
        }
    }
}