import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        sb.append("<");
        for (int i = 1; i <= N; i++) {
            Q.add(i);
        }

        while (Q.size() > 1) {
            for (int i = 1; i < K; i++) {
                Q.add(Q.poll());
            }
            int value = Q.poll();
            sb.append(value +", ");
        }
        sb.append(Q.poll() + ">");
        System.out.println(sb);
    }
}