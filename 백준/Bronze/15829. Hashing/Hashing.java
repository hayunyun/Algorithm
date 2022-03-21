import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int prime = 1234567891;
        long sum = 0;
        long b = 1;
        for (int i = 0; i < l; i++) {
            sum += ((s.charAt(i) - 96) * b) % prime;
            b = (b * 31) % prime;
        }
        System.out.println(sum % prime);
    }
}