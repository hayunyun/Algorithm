import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        int start = 0;
        for (int i = 1; i <= N; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m > start) {
                for (int j = start+1; j <= m; j++) { // start+1부터 입력값까지 push
                    stack.push(j);
                    sb.append("+\n");
                }
                start = m; // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 
            }
            // 맨 위의 원소가 입력값과 같지 않은 경우
            else if (stack.peek() != m) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}