import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans = Integer.MIN_VALUE;
    static char[] antatica = {'a', 'n', 't', 'i', 'c'};
    static char[][] chars;
    static ArrayList<Character> notLearn;
    static boolean[] vis, apb;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 단어 수
        k = Integer.parseInt(st.nextToken()) - 5; // 가르치는 단어 수

        apb = new boolean[26];
        for (int i = 0; i < 5; i++) {
            apb[antatica[i] - 'a'] = true;
        }

        chars = new char[n][];
        notLearn = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            chars[i] = new char[str.length()];
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = str.charAt(j);
                if (!apb[chars[i][j] - 'a'] && !notLearn.contains(chars[i][j])) {
                    notLearn.add(chars[i][j]);
                }
            }
        }

        if (k < 0) {
            System.out.println(0);
        } else if (k >= 21 || notLearn.size() <= k) {
            System.out.println(n);
        }
        else {
            cntWord(0, 0);
            System.out.println(ans);
        }
    }

    static void cntWord(int idx, int cnt) {
        if (cnt == k) {
            // k개만큼 배웠다면, 몇개의 단어를 알 수 있는지 체크
            int words = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < chars[i].length; j++) {
                    char c = chars[i][j];
                    if (!apb[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) words++;
            }
            ans = Math.max(ans, words);
            return;
        }

        // 배우지 않은 단어들 k개만큼 조합 돌리기
        for (int i = idx; i < notLearn.size(); i++) {
            char c = notLearn.get(i);
            apb[c - 'a'] = true;

            cntWord(i + 1, cnt + 1);

            apb[c - 'a'] = false;
        }

    }

}
