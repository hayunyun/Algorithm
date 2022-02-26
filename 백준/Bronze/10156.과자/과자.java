import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = sc.nextInt(); // 과자 한 개 가격
        int n = sc.nextInt(); // 사려고 하는 과자 개수
        int m = sc.nextInt(); // 동수가 가진 돈
        
        int money = k * n - m;
        
        sc.close();
        
        System.out.println(money > 0 ? money : 0);
    }
}