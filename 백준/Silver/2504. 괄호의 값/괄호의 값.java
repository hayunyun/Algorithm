import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();

        String s = br.readLine();
        int score = 0;
        int now = 1;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case ('('):
                    st.push(c);
                    now *= 2;
                    break;
                case ('['):
                    st.push(c);
                    now *= 3;
                    break;
                case (')'):
                    if (st.isEmpty() || st.peek() != '(') {
                        flag = false;
                        break;
                    }
                    else if (i > 0 && s.charAt(i - 1) == '(') score += now;
                    st.pop();
                    now /= 2;
                    break;
                case (']'):
                    if (st.isEmpty() || st.peek() != '[') {
                        flag = false;
                        break;
                    }
                    else if (i > 0 && s.charAt(i - 1) == '[') score += now;
                    st.pop();
                    now /= 3;
                    break;
                default:
                    flag = false;
                    break;
            }
        }

        System.out.println(!flag || !st.isEmpty() ? 0 : score);
    }
}