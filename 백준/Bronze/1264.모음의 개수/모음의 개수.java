import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] str = br.readLine().toLowerCase().toCharArray();
            int count = 0;
            if (str[0] == '#') break;
            else if (sb.length() != 0) sb.append("\n");
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'a' | str[i] == 'e' | str[i] == 'i' | str[i] == 'o' | str[i] == 'u')
                    count += 1;
            }
            sb.append(count);
        }

        System.out.println(sb);
    }
}