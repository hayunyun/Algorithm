import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        String[] str = new String[5];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            max = Integer.max(max, str[i].length());
        }

        for (int i = 0; i < max; i++) { // 글자수
            for (int j = 0; j < 5; j++) {
                if (str[j].length() > i)
                    sb.append(str[j].charAt(i));
            }
        }

        System.out.println(sb);
    }
}