import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int[] arr;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        
        dfs(0);
        System.out.print(sb);
    }
    
    static void dfs(int depth) throws IOException {
        // 1. 체크인
        // 2. 목적지인가? - 길이가 같으면
        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        // 3. 순회
        for (int i = 0; i < N; i++) {
            // 4. 갈 수 있는가? -> 본인보다 큰 수 인가?
            if (depth == 0 || i+1 >= arr[depth-1]) {
                arr[depth] = i + 1;
                dfs(depth + 1);
            }
            // 5. 간다
        }
        // 6. 체크아웃
    }
}