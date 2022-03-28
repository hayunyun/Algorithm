import java.io.*;
import java.util.*;

class Info {
    int index, value;

    public Info (int idx, int val) {
        this.index = idx;
        this.value = val;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            ArrayList<Integer> rank = new ArrayList<>();
            Queue<Info> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                q.add(new Info (j, val));
                rank.add(val);
            }
            
            Collections.sort(rank, Collections.reverseOrder());

            int cnt = 0;
            while (!q.isEmpty()) {
                // 맨 앞의 값이 가장 중요도가 큰 값인가?
                Info first = q.poll();
                if (first.value < rank.get(0)) {
                    q.add(first);
                }
                else {
                    cnt++;
                    if (first.index == idx) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    rank.remove(0);
                }
            }
        }
        System.out.println(sb);
    }
}