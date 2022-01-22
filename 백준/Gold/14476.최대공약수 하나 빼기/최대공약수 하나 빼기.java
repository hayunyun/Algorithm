import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums, gcdLtoR, gcdRtoL;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        gcdLtoR[0] = nums[0];
        gcdRtoL[N-1] = nums[N-1];
        for (int i = 1; i < N; i++) { // 시작점 주의 (초기값 잡아줬으니 그 다음부터)
            gcdLtoR[i] = gcd(gcdLtoR[i - 1], nums[i]);
        }
        for (int i = N - 2; i >= 0; i--) { // 시작점 주의 (초기값 잡아줬으니 그 다음부터)
            gcdRtoL[i] = gcd(gcdRtoL[i + 1], nums[i]);
        }
        
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            if (i == 0) { // 맨 왼쪽 제외
                gcd = gcdRtoL[1];
            }
            else if (i == N - 1) { // 맨 오른쪽 제외
                gcd = gcdLtoR[N - 2];
            }
            else {
                gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]); // 해당값만 빼고 양쪽 값
            }

            if (nums[i] % gcd != 0 && gcd > max) { // k가 gcd로 나눠지면 안됨(약수가 아님) && 최대값보다 크다면
                max = gcd; // 최대값 변경
                maxIndex = i;
            }
        }

        if (max == -1)
            bw.write(String.valueOf(max));
        else {
            bw.write(max + " " + nums[maxIndex]);
        }
        bw.flush();
    }

    // gcd(a, b) == gcd(b, a%b), stop when a % b == 0
    static int gcd(int a, int b) {
        while (b!=0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}