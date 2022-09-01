import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int cnt, cur;
        String mtd;

        public Info(int cnt, int cur, String mtd) {
            this.cnt = cnt;
            this.cur = cur;
            this.mtd = mtd;
        }
    }
    static int a, b;
    static StringBuilder sb = new StringBuilder();
    static boolean[] nums; // 0 ~ 10000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            nums = new boolean[10001];
            dslr();
        }
        System.out.println(sb);
    }

    static void dslr() {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, a, ""));

        while (!q.isEmpty()) {
            Info now = q.poll();
            int cnt = now.cnt;
            int cur = now.cur;
            String mtd = now.mtd;

            if (cur == b) {
                sb.append(mtd).append("\n");
                return;
            }

            if (!nums[cur]) {
                nums[cur] = true;
                q.add(new Info(cnt + 1, cur * 2 % 10000, mtd + "D"));
                q.add(new Info(cnt + 1, (cur - 1) < 0 ? 9999 : cur - 1, mtd + "S"));

                int leftMod = cur % 1000;
                int leftDiv = cur / 1000;
                q.add(new Info(cnt + 1, leftMod * 10 + leftDiv, mtd + "L"));

                int rightMod = cur % 10;
                int rightDiv = cur / 10;
                q.add(new Info(cnt + 1, rightMod * 1000 + rightDiv, mtd + "R"));
            }
        }
    }
}
