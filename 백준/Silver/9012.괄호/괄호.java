import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        
        for (int i = 0; i < T; i++) {
            stack = new Stack<>();
            char[] n = br.readLine().toCharArray();
            for (char text : n) {
                if (text=='(')
                    stack.push(text);
                else { // ')'라면
                    if (stack.size() > 0) {
                        char pop = stack.pop();
                        if (pop != '(') { // pop 한게 짝이 아니면
                            break;
                        }
                    }
                    else { // ')'인데 안에 든 게 없으면
                        stack.push(text);
                        break;
                    }
                }
            }
            if (stack.size() > 0) sb.append("NO");
            else sb.append("YES");

            sb.append("\n");
        }
        System.out.print(sb);
    }
}