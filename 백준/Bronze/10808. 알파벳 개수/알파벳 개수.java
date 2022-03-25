import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int[] apbs = new int[26];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            apbs[str.charAt(i) - 'a']++;
        }
        for (int apb : apbs)
            System.out.print(apb + " ");
    }

}