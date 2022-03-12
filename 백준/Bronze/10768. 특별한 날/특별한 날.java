import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        if (A < 2 || A == 2 && B < 18)
            System.out.println("Before");
        else if (A > 2 || A == 2 && B > 18)
            System.out.println("After");
        else {
            System.out.println("Special");
        }
    }
}