import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 시간이 가장 적게 걸리는 사람부터 줄세우기
        Arrays.sort(people);

        int prev = 0; int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += prev + people[i];
            prev += people[i];
        }

        System.out.println(ans);

    }
}
