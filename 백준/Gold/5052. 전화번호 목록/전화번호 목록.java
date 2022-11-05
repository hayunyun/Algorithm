import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    /*
    한번호가 다른번호의 접두어면 안됨
     */
    static int n;
    static String[] strs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = br.readLine();
            }

            Arrays.sort(strs);

//            System.out.println(Arrays.toString(strs));
            if (check()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean check() {
        HashSet<String> set = new HashSet<>();
        set.add(strs[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < strs[i].length(); j++) {
                String s = strs[i].substring(0, j);
                if (set.contains(s)) return false;
            }
            set.add(strs[i]);
        }

        return true;
    }
}
