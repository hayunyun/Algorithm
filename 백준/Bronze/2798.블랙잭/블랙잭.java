import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i=0; i<N; i++) { // 한
            for (int j=i+1; j<N; j++) { // 장
                for (int z=j+1; z<N; z++) { // 씩
                    if (cards[i]+cards[j]+cards[z] <= M) { // 세 카드의 합이 M보다 작다면
                        if (M-(cards[i]+cards[j]+cards[z]) < M-ans) { // M에 더 가깝다면
                            ans = cards[i]+cards[j]+cards[z];
                        }
                    }
                }
            }
        }
        bw.write(ans+" ");
        bw.flush();
    }
}