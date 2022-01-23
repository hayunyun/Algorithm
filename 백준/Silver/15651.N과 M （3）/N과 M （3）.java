import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
// // import java.util.Arrays;
// // import java.util.Collection;
// import java.util.Collections;
// import java.util.List;
// import java.util.Comparator;

public class Main {
    static boolean[] check;
    static int[] arr;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // check = new boolean[N];
        arr = new int[M];
        
        dfs(0);
        System.out.print(sb);
    }
    
    static void dfs(int depth) throws IOException {
        // 1. 체크인 (방문) - 생략
        // 2. 목적지인가?
        if (depth == M) { // 글자수 같다면 목적지
            // check[depth - 1] = false;
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }
        // 3. 순회
        for (int i = 0; i < N; i++) {
            // 4. 갈 수 있는가? - 문을 닫지 않았다면
            // if (!check[i]) {
                // check[i] = true;
                // 5. 간다
                arr[depth] = i + 1;
                dfs(depth + 1);
                // check[i] = false;
            // }
        // 6. 체크아웃 - 생략
        }
    }
}

// System.setIn(new FileInputStream("src/input.txt"));
// StringBuilder sb = new StringBuilder();
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
// StringTokenizer st = new StringTokenizer(br.readLine());
// int N = Integer.parseInt(st.nextToken());
// int M = Integer.parseInt(st.nextToken());