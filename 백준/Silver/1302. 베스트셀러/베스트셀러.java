import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	String book = br.readLine();
        	map.put(book, map.getOrDefault(book, 0) + 1);
        }
        
        int ans = Integer.MIN_VALUE;
        String maxBook = "";
        for (Map.Entry<String, Integer> m : map.entrySet()) {
        	if (ans < m.getValue()) {
        		ans = m.getValue();
        		maxBook = m.getKey();
        	}
        }
        
        System.out.println(maxBook);
	}
}
