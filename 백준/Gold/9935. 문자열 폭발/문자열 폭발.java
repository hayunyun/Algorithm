import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Character> st = new Stack<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
        	st.push(chars[i]);
        	
        	if (st.size() >= boom.length) {
        		boolean flag = true;
        		// 문자열을 폭발시킬 수 있는지 판단
        		for (int j = 0; j < boom.length; j++) {
        			if (st.get(st.size() - boom.length + j) != boom[j]) {
        				flag = false;
        				break;
        			}
        		}
        		
        		// 폭발시킬 수 있다면, 문자열의 길이만큼 pop
        		if (flag) {
        			for (int j = 0; j < boom.length; j++) {
        				st.pop();
        			}
        		}
        	}
        }
        
        String ans;
        if (st.isEmpty()) {
        	ans = "FRULA";
        } else {
        	StringBuilder sb = new StringBuilder();
        	for (char c : st) {
        		sb.append(c);
        	}
        	ans = sb.toString();
        }
        
        System.out.println(ans);
	}

}
