import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -부호를 받은순간을 기점으로, 그전은 싹다 더하고 그후는 싹다 뺴줌

        // 숫자 받기
        String str = br.readLine();
        String[] nums = str.split("-");

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {   	
        	// 더해주기
        	if (i == 0) {
        		String[] realNums = nums[0].split("\\+");
        		for (String s : realNums) {
        			sum += Integer.parseInt(s);        			
        		}
        		if (nums.length == 1) break;
        	}
        	// 빼주기
        	else {
        		String[] realNums = nums[i].split("\\+|\\-");
        		for (String s : realNums) {
        			sum -= Integer.parseInt(s);        			
        		}
        	}
        }

        System.out.println(sum);
        
	}

}
