import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int)(n*0.78) + " " + ((int)(n*0.80) + (int)(n*0.2*0.78)));
    }
}