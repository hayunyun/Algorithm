import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        // 초기화
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (x==1) { // find
                if (find(a) == find(b))
                    bw.write("YES\n");
                else bw.write("NO\n");
            }
            else { // union
                union(a, b);
            }
        }
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        arr[aRoot] = bRoot;
    }

    static int find(int a) {
        if (arr[a] == a) return a;
        else {
            arr[a] = find(arr[a]);
            return arr[a];
        }
    }
}