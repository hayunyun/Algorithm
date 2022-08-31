import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.println(combination(n, m));
	}
	
	static BigInteger combination(int n, int m) {
		BigInteger ans = new BigInteger("1");
		for (int i = 0; i < m; i++) {
			ans = ans.multiply(new BigInteger(String.valueOf(n--)));
		}
		
		for (int i = m; i > 0; i--) {
			ans = ans.divide(new BigInteger(String.valueOf(m--)));
		}
		
		return ans;
	}
}
