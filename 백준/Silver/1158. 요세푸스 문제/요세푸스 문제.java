import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 1;
        while (!circle.isEmpty()) {
            int now = circle.poll();

            if (cnt == k || circle.isEmpty()) {
                ans.add(now);
                cnt = 0;
            }
            else {
                circle.add(now);
            }
            cnt++;
        }

        System.out.print("<");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(ans.get(i) + ", ");
        }
        System.out.println(ans.get(n-1) + ">");
    }
}
