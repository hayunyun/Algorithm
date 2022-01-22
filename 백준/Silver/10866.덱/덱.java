import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<String> Q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] next = br.readLine().split(" ");
            switch (next[0]) {
                case "push_back":
                    Q.addLast(next[1]);
                    break;
                case "push_front":
                    Q.addFirst(next[1]);
                    break;
                case "pop_front":
                    String first = Q.pollFirst();
                    if (first==null)
                        sb.append(-1);
                    else sb.append(first);
                    sb.append("\n");
                    break;
                case "pop_back":
                    String last = Q.pollLast();
                    if (last==null)
                        sb.append(-1);
                    else sb.append(last);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(Q.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (Q.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case "front":
                    String front = Q.peekFirst();
                    if (front == null)
                        sb.append(-1);
                    else sb.append(front);
                    sb.append("\n");
                    break;
                case "back":
                    String back = Q.peekLast();
                    if (back == null)
                        sb.append(-1);
                    else sb.append(back);
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}