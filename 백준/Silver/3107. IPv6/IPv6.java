import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(":");
        ArrayList<String> tmp = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        // 빈 문자열 개수 세기
        int zero = 0;
        for (int i = 0; i < strs.length; i++) {
        	if (strs[i].length() == 0) {
        		zero++;
        		tmp.add("-1");
        	} else {
        		String t = "";
        		for (int j = 0; j < 4 - strs[i].length(); j++) {
        			t += "0";
        		}
        		tmp.add(t + strs[i]);
        	}
        }

        boolean flag = true;
        for (String s : tmp) {
        	if (s.equals("-1")) {
        		if (!flag) continue;
        		for (int j = 0; j < 8 - (strs.length - zero); j++) {
    				ans.add("0000");
    			}
        		flag = false;
        	} else {
        		ans.add(s);
        	}
        }
        
        
        if (ans.size() < 8) {
        	for (int j = 8 - ans.size(); j > 0; j--) {
				ans.add("0000");
			}
        }
        
        System.out.println(String.join(":", ans));
	}

}
