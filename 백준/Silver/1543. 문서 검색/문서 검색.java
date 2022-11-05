import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine();
        String str = br.readLine();
        
        int cnt = 0;
        boolean[] check = new boolean[docs.length()];
        for (int i = 0; i < docs.length(); i++) {
        	char c = docs.charAt(i);
        	
        	if (!check[i] && c == str.charAt(0)) {
        		boolean flag = true;
        		for (int j = 1; j < str.length(); j++) {
        			if ((i+j) >= docs.length() || docs.charAt(i+j) != str.charAt(j)) {
        				flag = false;
        				break;
        			}
        		}
        		
        		if (flag) {
        			for (int j = i; j < i + str.length(); j++) {
        				check[j] = true;
        			}
        			cnt++;
                    i += str.length() - 1;
        		}
        	}
        }
        
        System.out.println(cnt);
	}
}
