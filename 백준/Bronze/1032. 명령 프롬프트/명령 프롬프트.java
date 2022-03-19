import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < str[0].length(); i++) { // 글자수
            if (n == 1) {
                sb.append(str[0]);
                break;
            }
            for (int j = 0; j < str.length - 1; j++) {
                if (str[j].charAt(i) == str[j+1].charAt(i)) {
                    if (j == str.length - 2)
                        sb.append(str[j].charAt(i));
                }
                else {
                    sb.append("?");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}