import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T --> 0) {
            int X = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            int P = X;
            while(P >= 2) {
                int remainder = P % 2;
                int divide = P / 2;
                sb.append(remainder);
                P = divide;
            }
            String str = sb.append(P).toString();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    System.out.print(i  + " ");
                }
            }
        }
    }
}