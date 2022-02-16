import java.io.*;

public class Main {
    static long[] Dy;

    static void preprocess() {
        Dy = new long[1000001];
        // 초기값 구하기
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 4; i < Dy.length; i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2] + Dy[i-3]) % 1000000009;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        preprocess();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(Dy[x]).append('\n');
        }
        System.out.print(sb);
    }
}
