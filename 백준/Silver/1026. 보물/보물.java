import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] aList = new int[n];
        int[] bList = new int[n];

        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aList);

        st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bList);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += bList[n - 1 - i] * aList[i];
        }
        System.out.println(ans);
    }
}