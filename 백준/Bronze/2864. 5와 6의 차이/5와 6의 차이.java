import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();

        while (a > 0) {
            aList.add(a % 10);
            a /= 10;
        }

        while (b > 0) {
            bList.add(b % 10);
            b /= 10;
        }

        int aMin = 0;
        int aMax = 0;
        int ten = 1;
        for (int i = 0; i < aList.size(); i++) {
            int num = aList.get(i);
            aMin += (num == 6 ? 5 : num) * ten;
            aMax += (num == 5 ? 6 : num) * ten;
            ten *= 10;
        }

        int bMin = 0;
        int bMax = 0;
        ten = 1;
        for (int i = 0; i < bList.size(); i++) {
            int num = bList.get(i);
            bMin += (num == 6 ? 5 : num) * ten;
            bMax += (num == 5 ? 6 : num) * ten;
            ten *= 10;
        }

        System.out.println((aMin + bMin) + " " + (aMax + bMax));
    }
}