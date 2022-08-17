import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int rCnt;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            rCnt = 0;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for (int j = 0; j < n; j++) {
                deq.add(Integer.parseInt(st.nextToken()));
            }

            check(p);
        }

        System.out.println(sb);
    }

    static void check(String p) {
        for (int j = 0; j < p.length(); j++) {
            char c = p.charAt(j);
            switch (c) {
                case 'R':
                    rCnt++;
                    break;
                case 'D':
                    if (rCnt % 2 == 0) {
                        if (deq.poll() == null) {
                            sb.append("error").append("\n");
                            return;
                        }
                    } else {
                        if (deq.pollLast() == null) {
                            sb.append("error").append("\n");
                            return;
                        }
                    }
                    break;
            }
        }

        print();
    }

    static void print() {
        sb.append("[");
        if (!deq.isEmpty()) {
            if (rCnt % 2 == 0) {
                sb.append(deq.poll());
                while(!deq.isEmpty()) {
                    sb.append(",").append(deq.poll());
                }
            } else {
                sb.append(deq.pollLast());
                while(!deq.isEmpty()) {
                    sb.append(",").append(deq.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }
}
