import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int[] arr;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        check = new boolean[N];
        arr = new int[M];
        
        dfs(0);
        System.out.print(sb);
    }
    
    static void dfs(int depth) throws IOException {
        // 2. 목적지인가? - 들어간 숫자의 수가 M과 같은가
        if (depth == M) {
            // arr 배열 출력 후 return
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        // 3. 연결된 곳을 순회
        for (int i = 0; i < N; i++) {
            // 4. 갈 수 있는가? (방문하지 않았다면?) - bool false인 경우만 가능
            if (!check[i]) {
                // 1. 체크인 - bool true (해당 노드를 방문상태로 변경)
                check[i] = true;
                // 5. 간다
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i+1 저장
                dfs(depth+1);
                // 6. 체크아웃 - bool false. 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 사태로 변경
                check[i] = false; 
            }
        }
    }
}