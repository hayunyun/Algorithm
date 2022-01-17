import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i=0; i<N; i++) { //작은수를 구하므로 0부터 하나씩 구하기
            int num = i;
            int sum = 0; // 자릿수의 합을 담는 변수

            while (num != 0) {
                sum += num %10; // 자릿수의 합
                num = num/10;
            }

            if (sum+i==N) { //자릿수의 합 + 실제 숫자가 N과 같다면 (생성자를 찾은 경우)
                result = i;
                break;
            }
        }
        bw.write(result+"\n");
        bw.flush();
    }
}