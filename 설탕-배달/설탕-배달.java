import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i=0, j=0;

        for (i=0; i<N;i++) {
            for (j=0; j<N; j++) {
                if (5*i + 3*j == N) {
                    cnt = i+j; 
                    break;
                }
            }
        }
        bw.write(String.valueOf(cnt==0 ? -1 : cnt));
        bw.flush();
    }
}