import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, ans = Integer.MIN_VALUE;
    static char[] chars;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chars = br.readLine().toCharArray();

        vis = new boolean[n];

        backTrack(2, chars[0] - '0');
        System.out.println(ans);
    }

    static int cal(int n1, char buho, int n2) {
        int res = 0;
        switch (buho) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
        }
        return res;
    }

    static void backTrack(int idx, int res) {
        if (idx > n - 1) {
            ans = Math.max(ans, res);
            return;
        }

        // 1. 괄호로 묶을 수 있다면 -> 괄호 씌워 먼저 계산하고, 이전 값과 연산
        // 괄호 씌운 값 다음 숫자로 넘어가야 하므로 idx + 4
        if (idx + 2 < n) {
            int a = chars[idx] - '0';
            int b = chars[idx + 2] - '0';

            int cur = cal(a, chars[idx + 1], b);
            backTrack(idx + 4, cal(res, chars[idx - 1], cur));
        }

        // 2. 괄호 안 씌우고 계산
        // 이전 값과 현재 값 계산. 다음 숫자로 넘어가야 하므로 idx + 2
        backTrack(idx + 2, cal(res, chars[idx - 1], chars[idx] - '0'));
    }
}
