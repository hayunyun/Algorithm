import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        String[] balls = {"1", "2", "3"};

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int index_a = Arrays.asList(balls).indexOf(String.valueOf(a)); // 현재 a의 위치
            int index_b = Arrays.asList(balls).indexOf(String.valueOf(b)); // 현재 b의 위치
            
            String temp = balls[index_a];
            balls[index_a] = balls[index_b];
            balls[index_b] = temp;
        }
        bw.write(balls[0] + "\n");
        bw.flush();
    }
}