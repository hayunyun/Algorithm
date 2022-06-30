import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int[] cnt = new int[4]; // 소 대 숫 공
            String s = br.readLine();
            if (s == null) break;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLowerCase(c)) {
                    cnt[0]++;
                }
                else if (Character.isUpperCase(c)) {
                    cnt[1]++;
                }
                else if (Character.isDigit(c)) {
                    cnt[2]++;
                }
                else {
                    cnt[3]++;
                }
            }

            System.out.println(cnt[0] + " " + cnt[1] + " " +cnt[2] + " " + cnt[3] + " ");
        }
    }
}
