import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer> nums;
    static int[] sel;	
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new ArrayList<>();
        sel = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!nums.contains(num)) {
            	nums.add(num);
            }
        }

        Collections.sort(nums);
        select(0, 0);
        System.out.println(sb);
    }

    // 중복조합
    static void select(int idx, int cnt) {
        if (cnt == m) {
            for (int x : sel) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = idx; i < nums.size(); i++) {
            sel[cnt] = nums.get(i);
            select(i, cnt + 1);
        }
    }
}
