import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 짝수) 글자수 모두 짝수
	 * 홀수) 하나만 홀수(가운데에 들어감), 나머지 모두 짝수
	 */
	static boolean isOdd;
	static char[] chars;
	static int[] apbCnt;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().toCharArray();
        apbCnt = new int[26];
        
        for (int i = 0; i < chars.length; i++) {
        	apbCnt[chars[i] - 'A']++;
        }

        isOdd = (chars.length % 2 != 0);
        char[] ans = new char[chars.length];
        int idx = 0;
        if (isPossible()) {
        	// 짝수 -> 가장 맨앞의 알파벳부터 문자 양쪽 앞, 끝에 배치
        	// 홀수 -> 가장 정가운데에 배치 후 짝수와 똑같이 배치
        	for (int i = 0; i < 26; i++) {
        		char c = (char)(i + 'A');
        		if (apbCnt[i] % 2 != 0) { // 홀수
        			int mid = chars.length / 2;
        			ans[mid] = c;
        			apbCnt[i]--;
        		} 

        		while (apbCnt[i] > 0) {
    				ans[idx] = c;
    				ans[chars.length - 1 - idx++] = c;
    				apbCnt[i] -= 2;
    			}
        	}
        	System.out.println(new String(ans));
        } else {
        	System.out.println("I'm Sorry Hansoo");
        }
        
	}
	
	static boolean isPossible() {
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
        	if (!isOdd) { // 짝수
        		if (apbCnt[i] % 2 != 0) {
        			return false; // 하나라도 홀수가 있다면 false
        		} 
        	} else { // 홀수 - 하나만 홀수
        		if (apbCnt[i] % 2 != 0) {
        			if (flag) {
        				return false; // 이미 홀수가 있엇다면 false
        			} else {
        				flag = true; // 딱 하나의 홀수만 허용
        			}
        		}
        	}
        }
		
		return true;
	}
}
