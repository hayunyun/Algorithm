import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            Q.add(i);
        }

        while (Q.size() > 1) {
            Q.poll();
            int value = Q.poll();
            Q.add(value);
        }
        bw.write(Q.poll() + "\n");
        bw.flush();
    }
}