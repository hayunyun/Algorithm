import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            char[] S = br.readLine().toCharArray();
            if (S[0]=='.') break;
            for (int i = 0; i < S.length; i++) {
                if (S[i] == '(' || S[i] == '[') {
                    stack.push(S[i]);
                }
                else if (S[i] == ']' || S[i] == ')' ) {
                    if (stack.isEmpty()) {
                        stack.push(S[i]);
                        break;
                    }
                    else {
                        if ((S[i] == ']' && stack.peek() == '[' ) || (S[i] == ')' && stack.peek() == '('))
                            stack.pop();
                        else break;
                    }
                }
                else continue;
            }
            if (stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }
}