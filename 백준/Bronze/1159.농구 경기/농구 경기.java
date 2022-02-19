import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine());
        String[] players = new String[N];
        int[] names = new int[26];
        for (int i = 0; i < N; i++) {
            players[i] = br.readLine();
            names[players[i].charAt(0) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            if (names[i] >= 5)
                sb.append((char)(i+'a'));
        }
        if (sb.length() == 0)
            System.out.println("PREDAJA");
        else System.out.println(sb);
    }
}