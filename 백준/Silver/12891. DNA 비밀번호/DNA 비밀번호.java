import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int s, p, ans = 0;
    static char[] imsi;
    static int[] minCnt, nowCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        imsi = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        minCnt = new int[4];
        for (int i = 0; i < 4; i++) {
            minCnt[i] = Integer.parseInt(st.nextToken());
        }


        int left = 0;
        int right = p - 1;
        nowCnt = new int[4];
        for (int i = left; i <= right; i++) {
            addCnt(imsi[i]);
        }

        if (isGood()) ans++;

        // 왼쪽부터 돌면서 값 기록
        while (true) {
            subCnt(imsi[left++]);
            right++;
            if (right >= s) break;
            addCnt(imsi[right]);
            if (isGood()) ans++;
        }

        System.out.println(ans);
    }

    static boolean isGood() {
        for (int i = 0; i < 4; i++) {
            if (minCnt[i] > nowCnt[i]) return false;
        }
        return true;
    }

    static void addCnt(char c) {
        switch (c) {
            case 'A':
                nowCnt[0]++;
                break;
            case 'C':
                nowCnt[1]++;
                break;
            case 'G':
                nowCnt[2]++;
                break;
            case 'T':
                nowCnt[3]++;
                break;
        }
    }

    static void subCnt(char c) {
        switch (c) {
            case 'A':
                nowCnt[0]--;
                break;
            case 'C':
                nowCnt[1]--;
                break;
            case 'G':
                nowCnt[2]--;
                break;
            case 'T':
                nowCnt[3]--;
                break;
        }
    }
}
