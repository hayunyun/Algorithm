import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int n = Integer.parseInt(br.readLine());
        int i = 1;
        int row = 1;
        int col = 1;
        int ans = 1;

        while (i <= n) {
            if (i % 2 == 0) col += 1;
            else row += 1;
            ans = row * col;
            i++;
        }
        System.out.println(ans);
    }
}