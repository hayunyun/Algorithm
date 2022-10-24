import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(br.readLine()); // 다연이에게 만들어주려는 막대길이 x
        int stick = 64; // 현재 막대기 길이
        int cnt = 1; // 현재 사용한 막대기의 개수
        while (true) {
            if (x < stick) { // x보다 가지고 있는 막대기가 크다면
                stick /= 2; // 막대기를 이등분한다
            } 

            if (stick < 1) break; // 만약, 현재 막대기가 1보다 작아지면 연산을 종료한다 (무한루프 방지)

            if (x > stick) { // x가 막대기보다 커졌다면
                cnt++; // 해당 막대기를 사용한다
                x -= stick; // stick만큼 사용할 수 있으므로 x에서 stick을 빼준다
            } else if (x == stick) break; // 현재 막대기 길이와 x가 같다면 더이상 이등분할 필요가 없다


            // 이등분한 막대기 하나를 버리는 과정은 따로 구현하지 않으면 자동적으로 구현 됨
        }
        sb.append(cnt); // 답 출력
		
		System.out.println(sb);
	}

}
