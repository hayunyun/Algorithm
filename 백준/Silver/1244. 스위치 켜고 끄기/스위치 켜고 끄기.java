import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()) + 1;
        boolean[] switches = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int p = Integer.parseInt(br.readLine());
        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());

            switch (gender) {
                case 1: // 남
                    for (int j = now; j < n; j += now) {
                        switches[j] = !switches[j];
                    }
                    break;
                case 2: // 여
                    int left = now - 1;
                    int right = now + 1;

                    while (true) {
                        if (left < 1 || right >= n) break;
                        if (switches[left] != switches[right]) break;
                        
                        left--; right++;
                    }
                    
                    left++; right--;
                    for(int j = left; j <= right; j++) {
                        switches[j] = !switches[j];
                    }
                    
                    break;
            }
        }

        for (int i = 1; i < n; i++) {
            sb.append((switches[i] ? 1 : 0) + " ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}
