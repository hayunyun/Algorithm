import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Info implements Comparable<Info> {
		int num;
		String str;
		
		public Info(int num, String str) {
			this.num = num;
			this.str = str;
		}

		@Override
		public int compareTo(Info o) {
			return this.str.compareTo(o.str);
		}
	}
	static int n, m;
	static String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Info> infos = new ArrayList<>();
        
        for (int i = n; i <= m; i++) {
        	if (i < 10) {
        		infos.add(new Info(i, nums[i]));
        	} else {
        		String s = "";

    			s += nums[i / 10];
    			s += " ";
    			s += nums[i % 10];
    			
    			infos.add(new Info(i, s));
        	}
        }
        
        Collections.sort(infos);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infos.size(); i++) {
        	if (i != 0 && i % 10 == 0) {
        		sb.append("\n");
        	} else if (i != 0 && i % 10 != 0) {
        		sb.append(" ");
        	}
        	sb.append(infos.get(i).num);
        }
        System.out.println(sb);
	}

}
