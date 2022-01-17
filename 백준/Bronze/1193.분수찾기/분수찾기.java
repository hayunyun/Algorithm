import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int x = Integer.parseInt(br.readLine());
        int sum = 0;
        int cnt = 0;
        for (int i=0; sum<x; i++) {
            sum += i;
            cnt = i;
        }
        int a = cnt - (sum-x);  // 감소
        int b = (sum-x) + 1; // 증가
        
        if (cnt%2 == 0) // 입력한 수가 짝수
            bw.write(a +"/" + b);
        else    // 홀수
            bw.write(b +"/" + a);
        bw.flush();
    }
}