import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static String [] chars, sel;
	static boolean[] vis;
	static int ans;
	/*
	 * 1. 마지막 수가 0
	 * 2. 각 자리수를 더한 값이 3으로 나눠떨어져야 함
	 */
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chars = br.readLine().split("");
     
        int[] numCnt = new int[10];
        long sum = 0;
        for (int i = 0; i < chars.length; i++) {
        	char c = chars[i].charAt(0);
        	sum += (c - '0');
        	numCnt[c - '0']++;
        }

        if (numCnt[0] == 0 || sum % 3 != 0) {
        	System.out.println(-1);
        } else {
        	StringBuilder sb = new StringBuilder();
        	for (int i = 9; i >= 0; i--) {
        		while (numCnt[i] > 0) {
        			sb.append(i);
        			numCnt[i]--;
        		}
        	}
        	System.out.println(sb);
        }
	}
}
